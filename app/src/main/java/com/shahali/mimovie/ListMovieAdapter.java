package com.shahali.mimovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {

    List<com.shahali.mimovie.Movie> movies;
    Context context;
    public ListMovieAdapter(List<Movie> movies1, Context context1) {
        this.movies = movies1;
        this.context = context1;
    }

    public ListMovieAdapter(List<com.shahali.mimovie.Movie> listMoviePopular, FragmentActivity activity) {
    }

    @NonNull
    @Override
    public ListMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.movieName.setText(this.movies.get(position).getMovieName());
        Glide.with(context).load(this.movies.get(position).getMoviePoster())
                .centerCrop()
                .placeholder(R.drawable.movie)
                .into(holder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView movieName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_movie);
        }

    }


}
