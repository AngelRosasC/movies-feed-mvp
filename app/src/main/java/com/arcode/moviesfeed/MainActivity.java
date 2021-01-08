package com.arcode.moviesfeed;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arcode.moviesfeed.movies.MovieAdapter;
import com.arcode.moviesfeed.movies.MoviesMVP;
import com.arcode.moviesfeed.movies.ViewModel;
import com.arcode.moviesfeed.root.App;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesMVP.View {

    private final String TAG = MainActivity.class.getName();

    @BindView(R.id.activity_root_view)
    ViewGroup rootView;

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerView;

    @Inject
    MoviesMVP.Presenter presenter;

    private MovieAdapter movieAdapter;
    private List<ViewModel> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplication()).getComponent().inject(this);

        resultList = new ArrayList<>();
        movieAdapter = new MovieAdapter(resultList);
        mRecyclerView.setAdapter(movieAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        movieAdapter.notifyItemChanged(resultList.size() - 1);
        Log.d(TAG, "Información nueva: " + viewModel.getTitle());
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxJavaUnsuscribe();
        resultList.clear();
        movieAdapter.notifyDataSetChanged();
    }
}