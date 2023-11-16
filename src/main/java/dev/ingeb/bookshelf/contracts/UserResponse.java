package dev.ingeb.bookshelf.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse (
        String username,
        String email,
        @JsonProperty("firstname") String firstName,
        @JsonProperty("lastname") String lastName
) {}
