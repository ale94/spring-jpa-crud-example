package ar.com.ale94.spring_jpa_crud_example;

import ar.com.ale94.spring_jpa_crud_example.entity.UserEntity;
import ar.com.ale94.spring_jpa_crud_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringJpaCrudExampleApplication {

    private final UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaCrudExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            var user1 = UserEntity.builder()
                    .firstName("George")
                    .lastName("Lucas")
                    .email("glucas@gmail.com")
                    .phone("12345679")
                    .createdAt(LocalDateTime.now())
                    .build();
            var user2 = UserEntity.builder()
                    .firstName("Brad")
                    .lastName("Smith")
                    .email("brad@yahoo.com.ar")
                    .phone("987654321")
                    .createdAt(LocalDateTime.now())
                    .build();
            var user3 = UserEntity.builder()
                    .firstName("Selene")
                    .lastName("Friz")
                    .email("sele@outlook.com")
                    .phone("456123789")
                    .createdAt(LocalDateTime.now())
                    .build();
            repository.save(user1);
            repository.save(user2);
            repository.save(user3);
        };
    }

}
