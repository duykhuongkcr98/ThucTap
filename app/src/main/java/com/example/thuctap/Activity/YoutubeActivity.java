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
import org.jsoup.select.Elements;

import java.io.IOException;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    String API_KEY = "AIzaSyBQkjoD45SfYIJv5Rj5aUy0JByGvLMTqJo";
    private YouTubePlayerView youTubePlayerView;
    private int REQUEST_VIDEO = 123;
    private ProgressDialog progressDialog;
    private TextView tvCategory;
    private TextView tvTitle;
    private TextView tvContent;
    private  Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        intent = getIntent();

        tvTitle = findViewById(R.id.tv_title);
        youTubePlayerView = findViewById(R.id.myYoutube);
        youTubePlayerView.initialize(API_KEY,YoutubeActivity.this);

        getBodyText();

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

       // Toast.makeText(this,intent.getStringExtra("url"),Toast.LENGTH_SHORT).show();
        youTubePlayer.cueVideo(intent.getStringExtra("url"));
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
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

    private void getBodyText() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    String url="https://www.youtube.com/watch?v=" + intent.getStringExtra("url");//your website url
                    Document doc = Jsoup.connect(url).get();
                    Element docElement = doc.body();
//                    Log.d("Test", String.valueOf(docElement));
//                    Log.d("Test", String.valueOf(docElement.getElementsByClass("content style-scope ytd-video-secondary-info-renderer")));
//                    Elements body = doc.getElementsByClass("style-scope ytd-video-secondary-info-renderer");
                    builder.append(docElement.getElementsByClass("content style-scope ytd-video-secondary-info-renderer"));

                } catch (Exception e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvTitle.setText(builder.toString());
                    }
                });
            }
        }).start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
