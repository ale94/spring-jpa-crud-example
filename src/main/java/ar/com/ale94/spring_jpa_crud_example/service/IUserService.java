package ar.com.ale94.spring_jpa_crud_example.service;

import ar.com.ale94.spring_jpa_crud_example.dto.UserDTO;
import ar.com.ale94.spring_jpa_crud_example.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    UserEntity create(UserDTO user);

    Optional<UserEntity> getById(Long id);

    List<UserEntity> getAll();

    UserEntity update(Long id, UserDTO userUpdate);

    void delete(Long id);

}
