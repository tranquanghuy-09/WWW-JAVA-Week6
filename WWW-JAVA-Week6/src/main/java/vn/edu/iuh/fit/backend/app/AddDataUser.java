package vn.edu.iuh.fit.backend.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.services.UserService;

import java.time.Instant;

@Component
@Slf4j
@Order(1)
public class AddDataUser implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1l, "Tran", "Quang", "Huy", "123456789", "john@example.com", "quanghuy09", Instant.now(), Instant.now(), "Xin chào, tôi là John Doe.", "Profilr của tôi.", "../img/user2.jpeg");

        User user2 = new User(2l, "Alice", "Michael", "Smith", null, "alice@example.com", "quanghuy09", Instant.now(), Instant.now(), null, null, "../img/user3.jpeg");

        User user3 = new User(3l, "Emma", "Michael", "Johnson", null, "emma@example.com", "quanghuy09", Instant.now(), null, null, null, "../img/user4.jpeg");

        User user4 = new User(4l, "Robert", "Michael", "Wilson", null, "robert@example.com", "quanghuy09", Instant.now(), Instant.now(), "Tôi là Robert.", "Profile của tôi.", "../img/user5.jpeg");

        User user5 = new User(5l, "Sarah", "Michael", "Brown", null, "sarah@example.com", "quanghuy09", Instant.now(), null, "Xin chào, tôi là Sarah.", "Profile của tôi.", "../img/user6.jpeg");

        if (userService.save(user1)) {
            log.info("Add complete");
        } else {
            log.error("Add Error");
        }
        if (userService.save(user2)) {
            log.info("Add complete");
        } else {
            log.error("Add Error");
        }
        if (userService.save(user3)) {
            log.info("Add complete");
        } else {
            log.error("Add Error");
        }
        if (userService.save(user4)) {
            log.info("Add complete");
        } else {
            log.error("Add Error");
        }
        if (userService.save(user5)) {
            log.info("Add complete");
        } else {
            log.error("Add Error");
        }
    }
}
