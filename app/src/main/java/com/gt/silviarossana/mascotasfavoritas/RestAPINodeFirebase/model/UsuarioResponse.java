package com.gt.silviarossana.mascotasfavoritas.RestAPINodeFirebase.model;

/**
 * Created by Silvia Rossana on 4/03/2017.
 */

public class UsuarioResponse {

    private String id;
    private String token;
    private String usuarioInstagram;

    public UsuarioResponse(String usuarioInstagram, String token, String id) {
        this.usuarioInstagram = usuarioInstagram;
        this.token = token;
        this.id = id;
    }

    public UsuarioResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsuarioIntagram() {
        return usuarioInstagram;
    }

    public void setUsuarioIntagram(String usuarioIntagram) {
        this.usuarioInstagram = usuarioIntagram;
    }
}
