package com.example.thuctap.Activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thuctap.Adapter.SongAdapter;
import com.example.thuctap.Model.Song;
import com.example.thuctap.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SongAdapter adapter;
    ArrayList<Song> listsong = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        String[] arraysongname = getResources().getStringArray(R.array.song_name);
        String[] arraysingername = getResources().getStringArray(R.array.singer_name);
        String[] arrayurl = getResources().getStringArray(R.array.url);
        String[] arrayimg = getResources().getStringArray(R.array.img);

        for (int i = 0; i < arraysongname.length; i++) {

            listsong.add(new Song(arraysongname[i], getImage(this,arrayimg[i]), arraysingername[i], arrayurl[i]));
        }

        adapter = new SongAdapter(MainActivity.this, listsong);
        recyclerView.setAdapter(adapter);

    }

    public static int getImage(Context ctx, String ImageName) {
        return ctx.getResources().getIdentifier(ImageName, "drawable", ctx.getPackageName());
    }
}
