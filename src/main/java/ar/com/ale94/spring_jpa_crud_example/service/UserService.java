package ar.com.ale94.spring_jpa_crud_example.service;

import ar.com.ale94.spring_jpa_crud_example.dto.UserDTO;
import ar.com.ale94.spring_jpa_crud_example.entity.UserEntity;
import ar.com.ale94.spring_jpa_crud_example.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    @Override
    public UserEntity create(UserDTO user) {
        var userToPersist = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdAt(LocalDateTime.now())
                .build();
        var userPersisted = this.repository.save(userToPersist);
        log.info("User saved with id {}", userPersisted.getId());
        return this.repository.save(userPersisted);
    }

    @Override
    public UserEntity getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<UserEntity> getAll() {
        return this.repository.findAll();
    }

    @Override
    public UserEntity update(Long id, UserDTO userUpdate) {
        var userToUpdate = repository.findById(id).orElseThrow();
        userToUpdate.setFirstName(userUpdate.getFirstName());
        userToUpdate.setLastName(userUpdate.getLastName());
        userToUpdate.setPhone(userUpdate.getPhone());
        var userUpdated = repository.save(userToUpdate);
        log.info("User updated with id {}", userUpdated.getId());
        return userUpdated;
    }

    @Override
    public void delete(Long id) {
        var userToDelete = repository.findById(id).orElseThrow();
        this.repository.delete(userToDelete);
    }
}
