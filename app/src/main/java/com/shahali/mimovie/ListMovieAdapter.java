package com.shahali.mimovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.PlaceViewHolder> {

    Context context;
    List<Movie> movieList;
    MovieItemClickListener movieItemClickListener;

    // Create a constructive method
    public ListMovieAdapter(Context mContext, List<Movie> mPlaceList,MovieItemClickListener listener) {
        this.context = mContext;
        this.movieList = mPlaceList;
        movieItemClickListener=listener;
    }


    //Introducing the layer to be displayed
    @Override
    public ListMovieAdapter.PlaceViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,
                parent, false);
        return new PlaceViewHolder(view);
    }

    //Create the amount of views created on the image_item page   //set items
    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {
        Glide.with(context).load(movieList.get(position).getMovieImage())
                .centerCrop()
                .placeholder(R.drawable.movie)
                .into(holder.mPlace);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
    class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView mPlace;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            //call view
            mPlace = itemView.findViewById(R.id.img_movie);

            mPlace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMoveClick(movieList.get(getAdapterPosition()),mPlace);

                }
            });
        }
    }
}
