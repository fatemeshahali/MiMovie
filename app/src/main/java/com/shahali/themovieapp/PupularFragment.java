package com.shahali.themovieapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PupularFragment extends Fragment implements MovieItemClickListener {
    private RecyclerView mRecyclerView;
    List<Movies> listPupular;
    String URL;
    String RESULT_URL;
    String URL_Image = "https://image.tmdb.org/t/p/w500";
    String BASE_URL = "https://api.themoviedb.org/3/movie/";
    String API_KEY = "?api_key=6357bf9673a213aa08577f4f59fc1544  ";
    private RequestQueue requestQueue;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pupular, container, false);

        mRecyclerView = root.findViewById(R.id.recyclerview);

        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        requestQueue = Volley.newRequestQueue(getActivity());
        getDataNewMovie();

        return root;
    }
    //Show Recyclerview
    private void showRecyclerView() {
        ListAdapter newAdapter = new ListAdapter(getActivity(), listPupular, this);
        mRecyclerView.setAdapter(newAdapter);
    }


    @Override
    public void onMoveClick(Movies movie, ImageView movieImageView) {
        //there we send movie information to detail activity
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        //send movie information to detail activity
        intent.putExtra("MovieName", movie.getMovieName());
        intent.putExtra("MovieImage", movie.getMovieImage());
        intent.putExtra("MoviePoster", movie.getMoviePoster());
        intent.putExtra("ReleaseDate", movie.getReleaseDate());
        intent.putExtra("MovieSummary", movie.getMovieSummary());
        //create animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), movieImageView, "sharedName");
        startActivity(intent);
    }

    //Get data from api for popular movies
    public void getDataNewMovie() {
        listPupular = new ArrayList<>();
        RESULT_URL = "popular";
        URL = BASE_URL + RESULT_URL + API_KEY;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject results = jsonArray.getJSONObject(i);
                        String title = results.getString("title");
                        String poster_path = results.getString("poster_path");
                        String backdrop_path = results.getString("backdrop_path");
                        String overview = results.getString("overview");
                        String release_date = results.getString("release_date");
                        listPupular.add(new Movies(title, release_date, overview, URL_Image + backdrop_path + API_KEY, URL_Image + poster_path + API_KEY));

                    }

                    showRecyclerView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}