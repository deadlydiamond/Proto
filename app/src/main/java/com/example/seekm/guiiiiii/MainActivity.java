package com.example.seekm.guiiiiii;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.seekm.guiiiiii.MobileVerification1;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MAINACTIVITY";
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }catch (Error err){
            Log.d(TAG, "onCreate: Error");
        }
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();


        try{
            videoView= (VideoView) findViewById(R.id.videoView);
            Uri video = Uri.parse("android.resource://" + getPackageName() +"/"+ R.raw.video);
            videoView.setVideoURI(video);

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if(isFinishing())
                        return;

                    Intent intent = new Intent(MainActivity.this,MobileVerification1.class);
                    startActivity(intent);
                    finish();
                }
            });
            videoView.start();
        }catch (Error err){
            Log.d(TAG, "onCreateInMainActivity: " + err.getMessage());
            Intent intent = new Intent(MainActivity.this,MobileVerification1.class);
            startActivity(intent);
        }
    }

}
