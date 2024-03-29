package com.thanhhanh.dgv.repository;

import com.thanhhanh.dgv.entity.Cinema;
import com.thanhhanh.dgv.model.ResponseScheduleCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query(value = "SELECT `cinemas`.* FROM `cinemas`,`schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id`  = `cinemas`.`cinema_id` AND `schedule`.`schedule_id` = ?1", nativeQuery = true)
    Cinema getCinemasByIdSchedule(Integer schedule_id);

    @Query(nativeQuery = true, value = "SELECT `cinemas`.* FROM `cinemas`, `schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `schedule`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2")
    List<ResponseScheduleCinema> getScheduleCinema(Integer schedule_id, String schedule_date);
}
