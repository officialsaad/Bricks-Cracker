package com.usamamazhar20arid1744.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 3000; // 3 seconds
    private static final int PROGRESS_UPDATE_INTERVAL = 20; // 100 milliseconds
    private ProgressBar progressBar;
    private TextView progressText;
    private int progress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.bar);
        progressText = findViewById(R.id.count);

//        progressBar.setMax(100);
//        progressBar.setScaleY(3f);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    progress += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            progressText.setText(progress + "%");
                        }
                    });

                    try {
                        Thread.sleep(PROGRESS_UPDATE_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(splash.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).start();



    }


}




