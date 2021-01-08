package com.arcode.moviesfeed.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcode.moviesfeed.R;

import java.util.List;

import butterknife.BindView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListItemViewHolder> {

    private List<ViewModel> resultList;

    public MovieAdapter(List<ViewModel> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        ViewModel model = resultList.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.tvCountry.setText(model.getCountry());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_fragment_title)
        TextView tvTitle;

        @BindView(R.id.tv_fragment_country)
        TextView tvCountry;

        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

