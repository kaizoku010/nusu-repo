package com.wordpress.dixontechnologies.Mycashflow;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/*

  Created by ${Dixon} on 2/2/2017.
*/


public class McF_FirebaseMessagingService extends FirebaseMessagingService {


    private static final String TAG = "notifications" ;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From:" + remoteMessage.getFrom());

        //checking payloads
        if (remoteMessage.getData().size() > 0 ) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Message Notification Body: " +
                    remoteMessage.getNotification().getBody());
            sentNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sentNotification(String body) {
//        Intent intent = new Intent(this, HomeScreen.class);
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=com.wordpress.dixontechnologies.Mycashflow"));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("MyCashFlow")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }


    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }


}
