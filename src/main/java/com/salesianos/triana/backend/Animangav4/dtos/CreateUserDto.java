package com.salesianos.triana.backend.Animangav4.dtos;


import lombok.*;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CreateUserDto {
    private String username;

    private String image;

    private String fullName;

    private LocalDateTime createdAt;

}
