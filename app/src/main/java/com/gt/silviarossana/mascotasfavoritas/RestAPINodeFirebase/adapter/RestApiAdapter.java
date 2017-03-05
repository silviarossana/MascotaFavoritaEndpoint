package com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.adapter;


import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.ConstantesRespAPI;
import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.IEndpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Silvia Rossana on 4/03/2017.
 */

public class RestApiAdapter {

    public IEndpoints establecerConexionRestAPI(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRespAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IEndpoints.class);

    }

}
