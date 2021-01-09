package com.arcode.moviesfeed.movies;

import io.reactivex.rxjava3.core.Observable;

public class MoviesModel implements MoviesMVP.Model {

    private Repository repository;

    public MoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(repository.getResultData(), repository.getCountryData(), (result, country) -> new ViewModel(result.getTitle(), country));
    }
}
