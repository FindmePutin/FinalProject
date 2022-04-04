package com.example.omega_volley;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.SearchView;
//import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.app.SearchManager;

import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Game> gameList;
  //  private SearchView searchView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = VolleySingleton.getmSituation(this).getRequestQueue();

        gameList = new ArrayList<>();

        fetchGames();
        }

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filter(newText);
//                return true;
//            }
//        });
//
//    }

//    private void filter(String newText) {
//        List<Game> filteredList = new ArrayList<>();
//        for(Game game : gameList){
//            if(game.getTitle().toLowerCase().contains(newText.toLowerCase())){
//                filteredList.add(game);
//            }
//        }
//        adapter.filterList(filteredList);
//    }


    private void fetchGames(){

        String url = "https://www.freetogame.com/api/games";

        JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String thumbnail = jsonObject.getString("thumbnail");
                        String genre = jsonObject.getString("genre");
                        String description = jsonObject.getString("short_description");

                        Game game = new Game(title , thumbnail , genre , description);
                        gameList.add(game);


                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                    Adapter adapter = new Adapter(MainActivity.this , gameList);
                    recyclerView.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this , error.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        });

        requestQueue.add(jsonArrayRequest);

    }
}