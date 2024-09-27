package ar.com.ale94.spring_jpa_crud_example.repository;

import ar.com.ale94.spring_jpa_crud_example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
