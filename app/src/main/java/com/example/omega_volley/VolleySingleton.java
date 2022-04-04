package com.example.omega_volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private RequestQueue requestQueue;
    private static VolleySingleton mSituation;

    private VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getmSituation(Context context){

        if(mSituation ==null){
            mSituation = new VolleySingleton(context);

        }
        return mSituation;

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
