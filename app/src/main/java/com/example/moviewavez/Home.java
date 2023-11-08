package com.example.moviewavez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Home extends AppCompatActivity {
    EditText editTextSearchMovie;
    ImageView imageViewBtnSearch;
    ListView listViewMovieList;
    String apikey = "2bdb604b"; //your API KEY in omdbapi, Pls see their  website for the configuration


    interface RequestMovies {
        @GET("/")
        Call<MovieResponse> getMovies(@Query("s") String title,
                                      @Query("apikey") String apikey
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextSearchMovie = findViewById(R.id.editTextMovieName);
        imageViewBtnSearch = findViewById(R.id.imageViewButtonSearch);
        listViewMovieList = findViewById(R.id.movieListView);

        //retrofit configuration
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestMovies requestMovie = retrofit.create(RequestMovies.class);

        //listen the search the button
        imageViewBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieSearchName = editTextSearchMovie.getText().toString().trim();
                if(TextUtils.isEmpty(movieSearchName)){
                    Toast.makeText(Home.this, "Please enter a movie name", Toast.LENGTH_SHORT).show();
                }
                else{
                    Call <MovieResponse > call= requestMovie.getMovies(movieSearchName,apikey);
                    call.enqueue(new Callback<MovieResponse>() {
                        @Override
                        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                            //check if the response is success or not
                            if(response.isSuccessful()){

                                MovieResponse movieResponse = response.body();
                                //check if the response body is null
                                if (movieResponse != null && movieResponse.getSearchResults() != null) {
                                    List<Movie> movieList = movieResponse.getSearchResults();
                                    MoviesArrayAdapter moviesArrayAdapter=new MoviesArrayAdapter(getApplicationContext(),movieList);
                                    listViewMovieList.setAdapter(moviesArrayAdapter);
                                    // Handle the list of movies here
                                } else {
                                    Log.d("TAG", "Response body is null or empty");
                                }
                            }
                            else{
                                Log.d("TAG", "Response  is null or empty");
                            }
                        }

                        @Override
                        public void onFailure(Call<MovieResponse> call, Throwable t) {
                            //print eerror message
                            Log.e("TAG", "onFailure: " + t.getMessage());
                        }
                    });
                }

            }
        });
    }
}