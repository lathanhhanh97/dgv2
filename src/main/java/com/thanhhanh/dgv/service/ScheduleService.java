package com.thanhhanh.dgv.service;

import com.thanhhanh.dgv.entity.Cinema;
import com.thanhhanh.dgv.model.ResponseData;
import com.thanhhanh.dgv.model.ResponseScheduleCinema;
import com.thanhhanh.dgv.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public ResponseData<Cinema> getCinemaByScheduleId(Integer schedule_id){
        return new ResponseData(HttpStatus.OK, "success", scheduleRepository.getCinemasByIdSchedule(schedule_id));
    }

    public ResponseData<ResponseScheduleCinema> getScheduleCinema(Integer schedule_id, String schedule_date){
        return new ResponseData(HttpStatus.OK, "success", scheduleRepository.getScheduleCinema(schedule_id, schedule_date));
    }
}
