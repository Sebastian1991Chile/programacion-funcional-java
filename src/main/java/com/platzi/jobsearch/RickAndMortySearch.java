package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIPetition;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.*;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWhitName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildAPI;

public class RickAndMortySearch {
    public static void main(String[] args) {

        //Creación de un cli para interactuar por consola
        JCommander jCommander = buildCommanderWhitName("character-search", CLIArguments::newInstance);

        //Transformación de los parámetros ingresados en un Stream de objetos CLIArguments. Si el Optional está vacío, se crea una lista vacía. El Optional con la lista se convierte en stream para tener diversos parámetros. Finalmente se convierte cada objeto del nuevo stream en CLIArguments.
        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj->(CLIArguments) obj);

        //Filtra el Stream y crea uno nuevo solo con los parámetros válidos
        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getName() != null)
                .findFirst(); //trae la primera cantidad de parámetros que cumplen ambas características anteriores

        //Se convierte el stream de argumentos en algo que pueda procesarse en la URL. Si el stream está vació no pasanada, si tiene contenido, imprime el stream por pantalla.
        cliArgumentsOptional.map(CLIFunctions::toMap)// Toma un CLI y lo convierte a una estructura de llave - valor
                .map(RickAndMortySearch::executeRequest)
                .orElse(Stream.empty())// si el request genera error, crea un stream vacío
                .forEach(System.out::println); // imprime los resultados del request contenidos en el stream creado
    }

    /**
     * Función que toma los parametros y los convertirá en parte del request
     * @param params mapa con parametros en formato key - value
     * */
    private static Stream<Character> executeRequest(Map<String, Object> params){
        APIPetition api = buildAPI(APIPetition.class, "https://rickandmortyapi.com/api");
        return Stream.of(params) //retornaremos un stream
                .map(api::AllCharacters) //se llama al objeto API y se ejecuta el querry correspondiente
                .map(APIResponse::getResults) //El objeto retornado es reemplazado por una Lista interna
                .flatMap(Character -> Character.stream()); //De esa lista se crea un nuevo stream con cada elemento de la lista
    }
}
