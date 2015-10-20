package com.henri;

import com.henri.profiles.DevProfile;
import com.henri.profiles.ProdProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DevProfile.class, ProdProfile.class})
public class CourseListingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run (CourseListingAppApplication.class, args);
    }
    
}
