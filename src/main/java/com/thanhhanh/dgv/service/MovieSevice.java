package com.thanhhanh.dgv.service;

import com.thanhhanh.dgv.entity.Movie;
import com.thanhhanh.dgv.model.ResponseData;
import com.thanhhanh.dgv.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MovieSevice {
    @Autowired
    MovieRepository movieRepository;

    public ResponseData<Movie> getAllMovie(){
        return new ResponseData(HttpStatus.OK, "success", movieRepository.findAll());
    }

    public ResponseData<Movie> getMoviesNow(){
        if(movieRepository.getMoviesNow() == null){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", movieRepository.getMoviesNow());
        }
    }

    public ResponseData<Movie> getMoviesFuture(){
        if(movieRepository.getMoviesFuture() == null){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", movieRepository.getMoviesFuture());
        }
    }
}
