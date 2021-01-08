package com.arcode.moviesfeed.movies;

import io.reactivex.rxjava3.core.Observable;

public interface MoviesMVP {
    interface View {
        void updateData(ViewModel viewModel);

        void showSnackBar(String message);
    }

    interface Presenter {
        void loadData();

        void rxJavaUnsubscribe();

        void setView(MoviesMVP.View view);

    }

    interface Model {
        Observable<ViewModel> result();
    }
}
