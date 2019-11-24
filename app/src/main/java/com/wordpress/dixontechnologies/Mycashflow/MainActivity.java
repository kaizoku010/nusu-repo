package com.wordpress.dixontechnologies.Mycashflow;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.eftimoff.androipathview.PathView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        {

    View view;
    private PathView pathView;
    private View rootlay;
    String currency_type;
    NusuSplashView  splashView;
            private Handler mhandler;


            @Override
             protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                splashView = findViewById(R.id.splashView2);
                rootlay = findViewById(R.id.root_layout);

                splashView.setRemoveFromParentOnEnd(true); // remove the SplashView from MainView once animation is completed
                splashView.setSplashBackgroundColor(getResources().getColor(R.color.textColorPrimary)); // the background color of the view
                splashView.setRotationRadius(getResources().getDimensionPixelOffset(R.dimen.splash_rotation_radius)); // radius of the big circle that the little circles will rotate on
                splashView.setCircleRadius(getResources().getDimensionPixelSize(R.dimen.splash_circle_radius)); // radius of each circle
                splashView.setRotationDuration(getResources().getInteger(R.integer.splash_rotation_duration)); // time for one rotation to be completed by the small circles
                splashView.setSplashDuration(getResources().getInteger(R.integer.splash_duration)); // total time taken for the circles to merge together and disappear
                splashView.setCircleColors(getResources().getIntArray(R.array.splash_circle_colors)); // the colors of each circle in order

                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
                   animatePath();
                }
            }

    private void animatePath() {
        pathView = findViewById(R.id.pathView);
        pathView.setPathColor(R.color.colorPrimary);
        pathView.setFillAfter(true);
        pathView.getSequentialPathAnimator();
        pathView.getPathAnimator()
                .delay(500)//500+800 = 1300
                .duration(1000).listenerStart(() -> {
                    pathView.getPathAnimator().duration(600);
                    pathView.setCameraDistance(500f);
                }).listenerEnd(() -> pathView.setCameraDistance(50f))
                .interpolator(new AccelerateDecelerateInterpolator())
                .duration(800)
                .start();

        int time_OUT = 1000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent); }, time_OUT);


    }

    public void startSplass(){
        Random random = new Random();

        new Handler().postDelayed(() -> revealHomeScreen(), 8000 + random.nextInt(1000));
    }

    private void revealHomeScreen() {
      //  splashView = new NusuSplashView(getApplicationContext());
        splashView.splashAndDisappear(new NusuSplashView.ISplashListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onUpdate(float completionFraction) {
                if(BuildConfig.DEBUG){
                    Log.d("TAG__SCREEN", "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
                }/* else if (completionFraction == 100) {
                    splashView.splashAndDisappear(this);
                }*/

            }

            @Override
            public void onEnd() {
                splashView = null;
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);

        }
        });
    }

}




