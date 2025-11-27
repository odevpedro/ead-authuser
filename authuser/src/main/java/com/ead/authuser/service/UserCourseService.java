package com.ead.authuser.service;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserCourseService {
    boolean existsByUserCourseId(UserModel userModel, UUID courseId);

    UserCourseModel save(UserCourseModel userCourseModel);

    boolean existsByCourseId(UUID courseId);

    void deleteUserCourseByCourse(UUID courseId);

    public List<UserModel> findUsersIntoCourse(UUID courseId);
}
