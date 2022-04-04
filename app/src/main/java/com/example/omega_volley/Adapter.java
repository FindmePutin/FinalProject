package com.example.omega_volley;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.GameHolder> {

    private Context context;
    private List<Game> gameList;


    public Adapter(Context context , List<Game> games){
        this.context = context;
        gameList = games;
    }





    @NonNull
    @Override
    public GameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.item , parent, false);
         return new GameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameHolder holder, int position) {

        Game game = gameList.get(position);
        holder.genre.setText(game.getGenre());
        holder.title.setText(game.getTitle());
        holder.description.setText(game.getDescription());
        Glide.with(context).load(game.getThumbnail()).into(holder.imageView2);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , DetailActivity.class);


                Bundle bundle = new Bundle();
                bundle.putString("title" , game.getTitle());
                bundle.putString("thumbnail" , game.getThumbnail());
                bundle.putString("genre" , game.getGenre());
                bundle.putString("short_description" , game.getDescription());

                intent.putExtras(bundle);

                context.startActivity(intent);




            }
        });

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class GameHolder extends RecyclerView.ViewHolder{

        ImageView imageView2;
        TextView title , genre , description;
        ConstraintLayout constraintLayout;


        public GameHolder(@NonNull View itemView) {
            super(itemView);

            imageView2 = itemView.findViewById(R.id.imageView2);
            title = itemView.findViewById(R.id.title_gm);
            genre = itemView.findViewById(R.id.genre);
            description = itemView.findViewById(R.id.description);
            constraintLayout = itemView.findViewById(R.id.ConstraintLayout);
        }
    }
//    public void filterList(List<Game> filteredList){
//        gameList = filteredList;
//        notifyDataSetChanged();
//
//    }


}
