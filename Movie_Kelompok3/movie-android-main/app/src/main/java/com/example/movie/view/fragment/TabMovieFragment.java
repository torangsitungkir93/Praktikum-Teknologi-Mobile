package com.example.movie.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movie.R;
import com.example.movie.adapter.FavoriteMovieAdapter;
import com.example.movie.database.AppDatabase;
import com.example.movie.database.MovieTable;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabMovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabMovieFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView rvMovieFav;
    private ArrayList<MovieTable> listMovieFav = new ArrayList<>();
    private AppDatabase appDatabase;
    private FavoriteMovieAdapter favoriteMovieAdapter;

    private TextView tvStatus;

    public TabMovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabMovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabMovieFragment newInstance(String param1, String param2) {
        TabMovieFragment fragment = new TabMovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMovieFav = view.findViewById(R.id.fragment_tabmovies_rv);
        tvStatus = view.findViewById(R.id.fragment_tabmovies_tv);
        rvMovieFav.setLayoutManager(new GridLayoutManager(getContext(), 2));

        if (this.appDatabase == null) {
            appDatabase = AppDatabase.initDatabase(getContext());
            Log.d("TabMovieFragment", "init appDatabase");
        }

        listMovieFav.addAll(appDatabase.movieDAO().getByCategory("movie"));
        favoriteMovieAdapter = new FavoriteMovieAdapter(getContext());
        favoriteMovieAdapter.notifyDataSetChanged();
        favoriteMovieAdapter.setData(listMovieFav);

        rvMovieFav.setAdapter(favoriteMovieAdapter);

        if (listMovieFav.isEmpty()) {
            tvStatus.setVisibility(View.VISIBLE);
        } else {
            tvStatus.setVisibility(View.GONE);
        }
    }
}