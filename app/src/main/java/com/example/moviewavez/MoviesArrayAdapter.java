package com.example.moviewavez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesArrayAdapter extends ArrayAdapter<Movie>{
    Context context;
    List<Movie> movies;

    private ImageView imageViewMovieImage;
    private TextView textViewMovieTitle,textViewMovieGenre,textViewMovieYear;

    public MoviesArrayAdapter(Context context, List<Movie> movies){
        super(context,R.layout.movie_items,movies );
        this.context=context;
        this.movies=movies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.movie_items, parent, false);

            textViewMovieTitle=convertView.findViewById(R.id.txtViewTitleMovie);
            textViewMovieYear=convertView.findViewById(R.id.txtViewTitleYear);
            textViewMovieGenre=convertView.findViewById(R.id.txtViewMovieGenre);
            imageViewMovieImage=convertView.findViewById(R.id.moviesImage);

            Movie movie=movies.get(position);
            textViewMovieTitle.setText(movie.getTitle());
            textViewMovieYear.setText(movie.getYear());
            textViewMovieGenre.setText(movie.getType());
            Picasso.get().load(movie.getPoster()).into(imageViewMovieImage);


            // Apply a fade-in animation
            Animation animation= AnimationUtils.loadAnimation(context,R.anim.fade_in);
            convertView.startAnimation(animation);

        }

//
//      if(mo!=null){
//          textViewMovieTitle.setText(movie.getTitle());
//          textViewMovieGenre.setText(movie.getType());
//          textViewMovieYear.setText(movie.getYear());
//
//      }

        return convertView;
    }
}
