package com.salesianos.triana.backend.Animangav4.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianos.triana.backend.Animangav4.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserResponse {

    protected String id;
    protected String name, image, username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime createdAt;


    public static UserResponse fromUser(User user) {

        return UserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .image(user.getImage())
                .name(user.getFullName())
                .createdAt(user.getCreatedAt())
                .build();
    }

}

