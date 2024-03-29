package com.thanhhanh.dgv.controller;

import com.thanhhanh.beta.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api schedule")
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "Lấy rạp theo suất chiếu")
    @GetMapping("/{schedule_id}")
    public ResponseEntity<?> getCinemaByScheduleId(@PathVariable Integer schedule_id){
        return ResponseEntity.ok(scheduleService.getCinemaByScheduleId(schedule_id));
    }

    @ApiOperation(value = "Get suất chiếu")
    @GetMapping("/{movie_id}/{date}")
    public ResponseEntity<?> getScheduleCinema(@PathVariable Integer movie_id, String date){
        return ResponseEntity.ok(scheduleService.getScheduleCinema(movie_id, date));
    }
}
