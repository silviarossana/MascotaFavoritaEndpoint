package com.gt.silviarossana.mascotasfavoritas.db;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Silvia Rossana on 1/03/2017.
 */

public class NotificationIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASE TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        //FirebaseCrash..enable(true);
        String token = FirebaseInstanceId.getInstance().getToken();
        this.enviarTokenRegistro(token);
        //Log.d(TAG, "Refreshed token: " + token);

    }

    private void enviarTokenRegistro(String token){

        Log.d(TAG, token);
    }

}
