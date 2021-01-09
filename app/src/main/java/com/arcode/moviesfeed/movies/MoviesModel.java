package com.arcode.moviesfeed.movies;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;

public class MoviesModel implements MoviesMVP.Model {

    private MoviesRepository repository;

    public MoviesModel(MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(repository.getResultData(), repository.getCountryData(), new BiFunction<Result, String, ViewModel>() {
            @Override
            public ViewModel apply(Result result, String country) throws Throwable {
                //TODO Cambiar el result.toString cuando tengamos el POJO de datos
                return new ViewModel(result.toString(), country);
            }
        });
    }
}
