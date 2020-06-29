package com.shahali.mimovie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class Popular extends Fragment {

    public Popular() {
        // Required empty public constructor
    }
    List<Movie> listMoviePopular;
    RecyclerView recyclerViewPopular;
    ProgressBar progressBar;
    String MovieURL;
    String URL;
    String imgURL="https://image.tmdb.org/t/p/w500/";
    String siteURL="https://api.themoviedb.org/3/movie/";
    String APIKey="?api_key=f0af1eac62e3efe5aeacec8754208a6e";
    RequestQueue requestQueue;
    String name;
    String year;
    String thumbnailPhoto;
    String description;
    String poster;
    static final String TAG = MovieFragment.class.getSimpleName();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_popular, container, false);
        recyclerViewPopular = root.findViewById(R.id.recycleViewPopular);
        progressBar=root.findViewById(R.id.ProgressBar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewPopular.setLayoutManager(gridLayoutManager);
        requestQueue = Volley.newRequestQueue(getActivity());
        getDataPopularMovie();
        return root;
    }
    private void ShowPopularMovie() {
        //Show Recyclerview
        ListMovieAdapter listMovieAdapter=new ListMovieAdapter(listMoviePopular,getActivity());
        recyclerViewPopular.setAdapter(listMovieAdapter);
    }
    //Get data from api for new movies
    public void getDataPopularMovie() {
        listMoviePopular = new ArrayList<>();
         MovieURL = "popular";
        URL = siteURL + MovieURL + APIKey;
        requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject results = jsonArray.getJSONObject(i);
                        String title = results.getString("title");
                        String poster_path = results.getString("poster_path");
                        String backdrop_path = results.getString("backdrop_path");
                        String overview = results.getString("overview");
                        String release_date = results.getString("release_date");
                        listMoviePopular.add(new Movie(title,release_date,overview,imgURL+backdrop_path+APIKey,imgURL+poster_path+APIKey));

                    }

                    ShowPopularMovie();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
