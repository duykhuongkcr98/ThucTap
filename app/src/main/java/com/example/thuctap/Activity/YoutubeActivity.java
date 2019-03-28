package com.example.thuctap.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thuctap.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    String API_KEY = "AIzaSyBQkjoD45SfYIJv5Rj5aUy0JByGvLMTqJo";
    YouTubePlayerView youTubePlayerView;
    int REQUEST_VIDEO = 1;
    private ProgressDialog progressDialog;
    private TextView tvCategory;
    private TextView tvTitle;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.myYoutube);
        youTubePlayerView.initialize(API_KEY,this);



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("F5tS5m86bOI");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(YoutubeActivity.this,REQUEST_VIDEO);
        }
        else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO){
            youTubePlayerView.initialize(API_KEY,YoutubeActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
