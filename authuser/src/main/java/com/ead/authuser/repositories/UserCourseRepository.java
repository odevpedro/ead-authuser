package com.ead.authuser.repositories;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserCourseRepository extends JpaRepository<UserCourseModel, UUID>, JpaSpecificationExecutor<UserCourseModel> {

    boolean existsByUserAndCourseId(UserModel userModel, UUID courseId);

    @Query(value = "select * from tb_users_courses where user_user_id = :userId", nativeQuery = true)
    List<UserCourseModel> findAllUserCourseIntoUser(@Param("userId") UUID userId);


    boolean existsByCourseId(UUID courseId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserCourseModel uc WHERE uc.courseId = :courseId")
    void deleteUserCourseByCourse(@Param("courseId") UUID courseId);


    List<UserCourseModel> findByCourseId(UUID courseId);

}
