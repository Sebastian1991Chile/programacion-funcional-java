package com.platzi.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {

    /**
     * Función que crea los argumentos de la consulta en base a los parametros ingresados a consola
     * @param cliArguments parametros ingresados
     * */
    public static Map<String, Object> toMap(CLIArguments cliArguments){
        Map<String, Object> params = new HashMap<>();

        params.put("name", cliArguments.getName());
        params.put("species", cliArguments.getSpecies());
        params.put("gender", cliArguments.getGender());
        params.put("origin", cliArguments.getOrigin());

        if(cliArguments.isAlive()){
            params.put("status", "Alive");
        }

        return params;
    }
}
