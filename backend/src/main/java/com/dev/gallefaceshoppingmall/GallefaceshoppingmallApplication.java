package com.dev.gallefaceshoppingmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dev.gallefaceshoppingmall.entity.Role;
import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.dev.gallefaceshoppingmall")
@ComponentScan("com.dev.gallefaceshoppingmall.service.impl")
public class GallefaceshoppingmallApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(GallefaceshoppingmallApplication.class, args);
    }

    public void run(String... args) {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (null == adminAccount) {
            User user = new User();

            user.setEmail("admin@gmail.com");
            user.setFirstname("admin");
            user.setSecondname("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setRole(Role.ADMIN);
            userRepository.save(user);

        }

    }

}

/*package com.dev.gallefaceshoppingmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dev.gallefaceshoppingmall.entity.Role;
import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.dev.gallefaceshoppingmall")
@ComponentScan("com.dev.gallefaceshoppingmall.service.impl")
public class GallefaceshoppingmallApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(GallefaceshoppingmallApplication.class, args);
    }

    public void run(String... args) {
        User adminAccount = userRepository.findbyRole(Role.ADMIN);
        if (null == adminAccount) {
            User user = new User();

            user.setEmail("admin@gmail.com");
            user.setFirstname("admin");
            user.setSecondname("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setRole(Role.ADMIN);
            userRepository.save(user);

        }

    }

}
*/