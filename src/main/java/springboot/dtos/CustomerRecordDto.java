package springboot.dtos;

import jakarta.validation.constraints.NotBlank;


public record CustomerRecordDto(@NotBlank String name,
                                @NotBlank String login,
                                @NotBlank String password,
                                @NotBlank String email,
                                @NotBlank String cpf) {
}