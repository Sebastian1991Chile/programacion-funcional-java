package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {

    /**
     *Función que crea un comando para usar en consola, con un nombre en particular y parámetros de uso.
     * @param cliName Nombre del comando que se usará en la consola.
     * @param argumentSupplier Parámetros disponibles para el comando.
     * @return JCommander
     * */
    static <T> JCommander buildCommanderWhitName(String cliName, Supplier<T> argumentSupplier){
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get()) //Agrega los parametros (opciones)
                .build();

        jCommander.setProgramName(cliName);

        return  jCommander;
    }

    /**
     * Función que transforma los parámetros introducidos en la terminal a objetos JAVA. Si los parámetros son válidos devuelve un Optional con una lista de objetos, si existe un error, un Optional vacío.
     * @param jCommander Objeto JCommander que se utilizará para interactuar en la consola.
     * @param arguments Parametros ingresados en la consola.
     * @param onError Función a ejecutar si se ingresa un parámetro no válido.
     * @return List - Object
     * */
    static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, Consumer<JCommander> onError){
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException paramEx){
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
