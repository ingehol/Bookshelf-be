package dev.ingeb.bookshelf.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.ingeb.bookshelf.enums.UserRole;

public record UserLoginResponse (
        Long userId,
        String username,
        String password,
        String email,
        @JsonProperty("firstname") String firstName,
        @JsonProperty("lastname") String lastName,
        UserRole userRole
) {}
