package com.salesianos.triana.backend.Animangav4.service;


import com.salesianos.triana.backend.Animangav4.dtos.*;
import com.salesianos.triana.backend.Animangav4.exception.EntityNotFoundException;
import com.salesianos.triana.backend.Animangav4.exception.ForbiddenException;
import com.salesianos.triana.backend.Animangav4.models.User;
import com.salesianos.triana.backend.Animangav4.models.UserRole;
import com.salesianos.triana.backend.Animangav4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final UserDtoConverter userDtoConverter;

    public User createUser(CreateUserDto createUserRequest, UserRole role) {
        User user = User.builder().username(createUserRequest
                        .getUsername()).fullName(createUserRequest.getFullName())
                .email(createUserRequest.getEmail())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .image(createUserRequest.getImage() == null ? "https://i.ibb.co/stxTwKC/user.png" : createUserRequest.getImage())
                .role(role).build();

        return userRepository.save(user);
    }

    public User createUserWithUserRole(CreateUserDto createUserRequest) {
        return createUser(createUserRequest, UserRole.USER);
    }

    public User createUserWithAdminRole(CreateUserDto createUserRequest) {
        return createUser(createUserRequest, UserRole.ADMIN);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public GetUserDto findById2(UUID id) {
        Optional<User> u = userRepository.findById(id);
        if (u.isPresent()) {
            return userDtoConverter.userToGetUserDto(u.get());
        }
        throw new EntityNotFoundException("No se ha encontrado el usuario con el id: " + id, User.class);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public User editUser(EditUserDto editUserDto, User user, UUID id) {
        Optional<User> u = userRepository.findById(id);
        if(u.isEmpty()){
            throw new EntityNotFoundException(user.getId().toString(), User.class);
        } else {
            if(user.getId().equals(id) || user.getRole().equals(UserRole.ADMIN)) {
                u.get().setFullName(editUserDto.getFullName());
                if(editUserDto.getEmail()!=null) {
                    u.get().setEmail(editUserDto.getEmail());
                }
                return userRepository.save(u.get());
            } else {
                throw new ForbiddenException("Permisos insuficientes");
            }
        }
    }

    public Optional<User> editPassword(UUID userId, String newPassword) {

        // Aquí no se realizan comprobaciones de seguridad. Tan solo se modifica

        return userRepository.findById(userId).map(u -> {
            u.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(u);
        }).or(() -> Optional.empty());

    }

    public void delete(User user) {
        deleteById(user.getId());
    }

    public void deleteById(UUID id) {
        // Prevenimos errores al intentar borrar algo que no existe
        if (userRepository.existsById(id)) userRepository.deleteById(id);
    }

    public boolean passwordMatch(User user, String clearPassword) {
        return passwordEncoder.matches(clearPassword, user.getPassword());
    }
}
