package com.thanhhanh.dgv.repository;

import com.thanhhanh.dgv.entity.User;
import com.thanhhanh.dgv.model.ResponseData;
import com.thanhhanh.dgv.model.ResponseScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //SELECT * FROM `users` WHERE `user_id` = user_id
    // lấy thông tin user bằng id
    @Query(value = "SELECT * FROM `users` WHERE `user_id` = ?1", nativeQuery = true)
    User getUserById(Integer user_id);
    //Thêm user vào dữ liệu ;
    @Query(value = "INSERT INTO `users`(`username`, `password`, `user_avatar`, `user_fullname`, `user_birthday`, `user_gender`, `user_email`, `user_city`, `user_phone`, `user_point`) VALUES ('?1','?2','?3','?4','?5','?6','?7','?8','?9', 0)", nativeQuery = true)
    ResponseData registerUser(String username);

    //Get suất chiếu
    @Query(name = "getScheduleTimeByFilm", nativeQuery = true)
    List<ResponseScheduleTime> getScheduleTime(Integer schedule_id, String schedule_start);

    //

}
