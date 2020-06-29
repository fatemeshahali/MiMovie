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
public class NowPlaying extends Fragment {

    public NowPlaying() {
        // Required empty public constructor
    }
    List<Movie> listMovieNowPlaying;
    RecyclerView recyclerViewNowPlaying;
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

        View root = inflater.inflate(R.layout.fragment_now_playing, container, false);
        recyclerViewNowPlaying = root.findViewById(R.id.recycleViewPNowPlaying);
        progressBar=root.findViewById(R.id.ProgressBar1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewNowPlaying.setLayoutManager(gridLayoutManager);
        requestQueue = Volley.newRequestQueue(getActivity());
        getDataNowPlayingMovie();
        return root;
    }
    private void ShowNwPlayingMovie() {
        //Show Recyclerview
        ListMovieAdapter listMovieAdapter=new ListMovieAdapter(listMovieNowPlaying,getActivity());
        recyclerViewNowPlaying.setAdapter(listMovieAdapter);
    }
    public void getDataNowPlayingMovie() {
        listMovieNowPlaying = new ArrayList<>();
        MovieURL = "now_playing";
        URL = siteURL + MovieURL + APIKey;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject results = jsonArray.getJSONObject(i);
                                name = results.getString("title");
                                year = results.getString("release_date");
                                poster = results.getString("poster_path");
                                description = results.getString("overview");
                                thumbnailPhoto = results.getString("backdrop_path");
                                listMovieNowPlaying.add(new Movie(name, year, description, imgURL + thumbnailPhoto + APIKey, imgURL + poster + APIKey));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ShowNwPlayingMovie();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.VISIBLE);
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
