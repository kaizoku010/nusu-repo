package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ${Dixon} on 2/6/2017.
 */
public class McF_FirebaseInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = "SHERRY";

    @Override
    public void onTokenRefresh() {
        String refresh = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refresh);
        final Intent intent = new Intent("tokenReceiver");
        // You can also include some extra data.
        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        intent.putExtra("token",refresh);
        broadcastManager.sendBroadcast(intent);
    }


}
