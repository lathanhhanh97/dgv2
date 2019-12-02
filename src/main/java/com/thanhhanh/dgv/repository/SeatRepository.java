package com.thanhhanh.dgv.repository;

import com.thanhhanh.dgv.entity.Seat;
import com.thanhhanh.dgv.model.ResponseSeatEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //lấy ghế trống theo id film và id schedule
    @Query(name = "getSeatEmpty", nativeQuery = true)
    List<ResponseSeatEmpty> getSeatEmptyBySchedule(Integer schedule_id);
}
