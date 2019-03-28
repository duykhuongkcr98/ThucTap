package com.example.thuctap.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuctap.Activity.MainActivity;
import com.example.thuctap.Activity.YoutubeActivity;
import com.example.thuctap.Model.Song;
import com.example.thuctap.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {
    Context context;
    ArrayList<Song> listsong;

    public SongAdapter(Context context, ArrayList<Song> listsong) {
        this.context = context;
        this.listsong = listsong;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_song,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final Song song = listsong.get(i);
        myViewHolder.tv_namesong.setText(song.getNameSong());
        myViewHolder.tv_namesinger.setText(song.getNameSinger());
        myViewHolder.img_Song.setImageResource(song.getImgSong());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,YoutubeActivity.class);
                intent.putExtra("url",song.getURL());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listsong.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img_Song;
        TextView tv_namesong;
        TextView tv_namesinger;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Song = itemView.findViewById(R.id.img_song);
            tv_namesinger = itemView.findViewById(R.id.tv_namesinger);
            tv_namesong= itemView.findViewById(R.id.tv_namesong);
        }
    }
}
