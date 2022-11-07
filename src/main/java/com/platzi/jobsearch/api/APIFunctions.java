package com.platzi.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

    /**
     * Función que crea objetos tipo API, el objeto será consumido como API
     * @param clazz Se menciona la clase que se va a generar
     * @param url La URL de la API que se utilizará
     * */
    static <T> T buildAPI(Class<T> clazz, String url){
        return Feign.builder() // Se construye el cliente web
                .decoder(new GsonDecoder()) // se decodifican los resultados utilizando Gson
                .target(clazz, url); //utiliza un objeto API creado para apuntar a una URL

    }
}
