package com.ead.authuser.clients;

import com.ead.authuser.dtos.CourseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Log4j2
@Component
public class UserClient {

    @Autowired
    RestTemplate restTemplate;

    //futuramente será add o service registry para trazer dinamismo
    String REQUEST_URI = "http://localhost:8082";

    public Page<CourseDto> getAllCoursesByUser(UUID userId, Pageable pageable) {
        List<CourseDto> searchRestul = null;
        String url = REQUEST_URI + "/courses?userId=" + userId + "&page=" + pageable.getPageNumber() + "&size="
                + pageable.getPageSize() + "&sort=" + pageable.getSort().toString().replaceAll(":", ",");
        try {
    log.debug("Response Number of Elements: {} ", searchRestul.size());
    } catch (HttpStatusCodeException exception) {
    log.debug("Error request /courses: {} ", exception);

    }
        log.info("Ending request /courses userId {}", userId);
        return ;

    }

}
