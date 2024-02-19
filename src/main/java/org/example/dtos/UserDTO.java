package org.example.dtos;

import org.example.domain.user.UserType;

public record UserDTO(String firtName, String lastName, String document, String email, String password, Double balance,
                      UserType userType) {
}
