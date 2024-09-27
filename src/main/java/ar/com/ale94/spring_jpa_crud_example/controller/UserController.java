package ar.com.ale94.spring_jpa_crud_example.controller;

import ar.com.ale94.spring_jpa_crud_example.dto.UserDTO;
import ar.com.ale94.spring_jpa_crud_example.entity.UserEntity;
import ar.com.ale94.spring_jpa_crud_example.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(user));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserDTO userUpdate) {
        return ResponseEntity.ok(service.update(id, userUpdate));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
