package com.arcode.moviesfeed.movies;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoviesPresenter implements MoviesMVP.Presenter {

    private MoviesMVP.View view;
    private MoviesMVP.Model model;

    private Disposable subscription = null;

    public MoviesPresenter(MoviesMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MoviesMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (view != null) {
            subscription = model.result()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ViewModel>() {
                        @Override
                        public void onNext(@NonNull ViewModel viewModel) {
                            view.updateData(viewModel);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                            view.showSnackBar("Error al descargar las peliculas...");
                        }

                        @Override
                        public void onComplete() {
                            view.showSnackBar("Información descargada con exito...");
                        }
                    });
        }
    }

    @Override
    public void rxJavaUnsubscribe() {
        if (subscription != null && !subscription.isDisposed())
            subscription.dispose();
    }


}
