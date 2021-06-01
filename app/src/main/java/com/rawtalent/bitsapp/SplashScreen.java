package com.rawtalent.bitsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    //    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        lottieAnimationView=findViewById(R.id.lottie);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        MotionLayout motionLayout = findViewById(R.id.motionLayout);
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                FirebaseAuth mauth = FirebaseAuth.getInstance();

                if (mauth.getCurrentUser() == null) {
                    Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, LoginActivity.class);
                    startActivity(myIntent);
                } else {
                    Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, MainActivity.class);
                    startActivity(myIntent);
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

            }
        });


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {

//                SharedPreferences sharedPref = getSharedPreferences("Shared_Pref", Context.MODE_PRIVATE);
//                boolean firstTime = sharedPref.getBoolean("FirstTime", true);
//                if (!firstTime) {
//                    Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, MainActivity.class);
//                    com.helpinghands.toursandtravels.SplashScreen.this.startActivity(myIntent);
//                    com.helpinghands.toursandtravels.SplashScreen.this.finish();
//                } else {
//                    Intent myIntent = new Intent(com.helpinghands.toursandtravels.SplashScreen.this, Login.class);
//                    com.helpinghands.toursandtravels.SplashScreen.this.startActivity(myIntent);
//                    com.helpinghands.toursandtravels.SplashScreen.this.finish();
//                }
//            }
//        }, 5200);
    }

//    private void () {
//        Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, LoginActivity.class);
//        startActivity(myIntent);
//        SplashScreen.this.finish();
//    }

//    private void gotoLoginPage() {
//        Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, LoginActivity.class);
//        startActivity(myIntent);
//        SplashScreen.this.finish();
//    }
//
//    private void gotoDashBoard() {
//        Intent myIntent = new Intent(com.rawtalent.bitsapp.SplashScreen.this, MainActivity.class);
//        startActivity(myIntent);
//        SplashScreen.this.finish();
//    }
}