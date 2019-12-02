package com.thanhhanh.dgv.service;

import com.thanhhanh.dgv.entity.Cinema;
import com.thanhhanh.dgv.model.ResponseData;
import com.thanhhanh.dgv.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;

    public ResponseData<Cinema> getCinemaByScheduleId(Integer schedule_id){
        return new ResponseData(HttpStatus.OK, "success", cinemaRepository.getCinemasByIdSchedule(schedule_id));
    }
}
