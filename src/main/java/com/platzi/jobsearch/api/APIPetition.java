package com.platzi.jobsearch.api;

import com.google.gson.JsonObject;
import com.platzi.jobsearch.APIResponse;
import com.platzi.jobsearch.Character;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Interfase que será la base de las peticiones que se harán con Feign

@Headers("Accept: application/json")
public interface APIPetition {

    //Aqui le decimos a Feign cómo debe ser la petición web
    @RequestLine("GET /character/")
    APIResponse AllCharacters(@QueryMap Map<String, Object> queryMap);

}
