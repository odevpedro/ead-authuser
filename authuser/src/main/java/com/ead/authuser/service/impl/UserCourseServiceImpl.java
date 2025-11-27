package com.ead.authuser.service.impl;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserCourseRepository;
import com.ead.authuser.repositories.UserRepository;
import com.ead.authuser.service.UserCourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    UserCourseRepository userCourseRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean existsByUserCourseId(UserModel userModel, UUID courseId) {
        return userCourseRepository.existsByUserAndCourseId(userModel, courseId);
    }

    @Override
    public UserCourseModel save(UserCourseModel userCourseModel) {
        return userCourseRepository.save(userCourseModel);
    }

    @Override
    public boolean existsByCourseId(UUID courseId) {
        return userCourseRepository.existsByCourseId(courseId);
    }

    @Transactional
    @Override
    public void deleteUserCourseByCourse(UUID courseId) {
        userCourseRepository.deleteAllByCourseId(courseId);
    }

    @Override
    public List<UserModel> findUsersIntoCourse(UUID courseId) {

        List<UserCourseModel> links = userCourseRepository.findByCourseId(courseId);

        if (links.isEmpty()) {
            return Collections.emptyList();
        }

        List<UUID> userIds = links.stream()
                .map(uc -> uc.getUser().getUserId())
                .toList();

        return userRepository.findAllById(userIds);
    }
}
