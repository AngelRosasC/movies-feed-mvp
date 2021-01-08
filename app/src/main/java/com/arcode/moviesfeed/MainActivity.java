package com.arcode.moviesfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arcode.moviesfeed.movies.MoviesMVP;
import com.arcode.moviesfeed.movies.ViewModel;
import com.arcode.moviesfeed.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesMVP.View {

    private final String TAG = MainActivity.class.getName();

    @BindView(R.id.activity_root_view)
    ViewGroup viewGroup;

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerView;

    @BindView(R.id.tv_fragment_title)
    TextView tvTitle;

    @BindView(R.id.tv_fragment_country)
    TextView tvCountry;

    @Inject
    MoviesMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplication()).getComponent().inject(this);

    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }
}