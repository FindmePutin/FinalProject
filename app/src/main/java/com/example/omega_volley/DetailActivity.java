package com.example.omega_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.thumbnail_View);
        TextView genre = findViewById(R.id.DGenre);
        TextView title = findViewById(R.id.DTitle);
        TextView descrption = findViewById(R.id.short_description);

        Bundle bundle = getIntent().getExtras();

        String DTitle = bundle.getString("title");
        String DThumbnail = bundle.getString("thumbnail");
        String DDescription = bundle.getString("short_description");
        String DGenre = bundle.getString("genre");

        Glide.with(this).load(DThumbnail).into(imageView);
        genre.setText(DGenre);
        title.setText(DTitle);
        descrption.setText(DDescription);



    }
}