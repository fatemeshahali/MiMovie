package com.shahali.themovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.PlaceViewHolder> {


    Context mContext;
    List<Movies> mPlaceList;
    MovieItemClickListener movieItemClickListener;

   // Create a constructive method
    public ListAdapter(Context mContext, List<Movies> mPlaceList, MovieItemClickListener listener) {
        this.mContext = mContext;
        this.mPlaceList = mPlaceList;
        movieItemClickListener=listener;
    }


    //Introducing the layer to be displayed
    @Override
    public ListAdapter.PlaceViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_movie,
                parent, false);
        return new PlaceViewHolder(view);
    }

    //Create the amount of views created on the image_item page   //set items
    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {
        Glide.with(mContext).load(mPlaceList.get(position).getMovieImage())
                .centerCrop()
                .placeholder(R.drawable.movie)
                .into(holder.mPlace);

    }

    @Override
    public int getItemCount() {
        //specify how many items we want to create according to the number of our list
        return mPlaceList.size();
    }

    //Create a class that inherits from RecyclerView.Adapter
    class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView mPlace;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            //call view
                mPlace = itemView.findViewById(R.id.img_movie);

            mPlace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //When the items are clicked, it passes the item to the onMoveClick method
                    movieItemClickListener.onMoveClick(mPlaceList.get(getAdapterPosition()),mPlace);

                }
            });
        }
    }
}