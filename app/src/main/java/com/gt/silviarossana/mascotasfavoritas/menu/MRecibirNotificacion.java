package com.gt.silviarossana.mascotasfavoritas.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.IEndpoints;
import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.adapter.RestApiAdapter;
import com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Silvia Rossana on 5/03/2017.
 */

public class MRecibirNotificacion extends AppCompatActivity {

    Toolbar tbBarraPrincipal;
    EditText etConfigurarNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrecibir_notificacion);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        etConfigurarNotificacion = (EditText)findViewById(R.id.etConfigurarNotificacion);
    }


    public void btnClickRegistrarFirebase(View view){

        if(!etConfigurarNotificacion.getText().toString().equals("")){

                String token = FirebaseInstanceId.getInstance().getToken();
                this.enviarTokenRegistro(token, etConfigurarNotificacion.getText().toString());

                Toast.makeText(this, "Registrado en Firebase: " + this.etConfigurarNotificacion.getText(), Toast.LENGTH_LONG).show();

        }else{
                Toast.makeText(this, "Introduzca datos del usuario Instagram", Toast.LENGTH_LONG).show();
        }


    }


    private void enviarTokenRegistro(String token, String usuarioInstagram){

        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IEndpoints endpoints = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarTokenId(token, usuarioInstagram);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE: ", usuarioResponse.getId());
                Log.d("TOKEN_FIREBASE: ", usuarioResponse.getToken());
                Log.d("USUARIO_FIREBASE: ", usuarioResponse.getUsuarioIntagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }

}
