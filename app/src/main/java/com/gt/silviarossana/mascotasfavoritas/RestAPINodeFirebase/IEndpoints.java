package com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase;



import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Silvia Rossana on 4/03/2017.
 */

public interface IEndpoints {

    @FormUrlEncoded
    @POST(ConstantesRespAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("token") String token, @Field("usuarioInstagram") String usuarioInstagram);

}
