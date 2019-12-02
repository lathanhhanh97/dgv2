package com.thanhhanh.dgv.service;

import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    SeatRepository seatRepository;


    public ResponseData<Integer> getSeatEmpty(Integer schedule_id){

        if(seatRepository.getSeatEmptyBySchedule(schedule_id).size() == 0){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", seatRepository.getSeatEmptyBySchedule(schedule_id));
        }
    }
}
