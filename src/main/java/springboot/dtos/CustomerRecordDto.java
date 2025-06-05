package springboot.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CustomerRecordDto(@NotBlank String name, @NotBlank String login, @NotBlank String password,
                                @NotBlank String email, @NotBlank
                                LocalDate dateCreation, LocalDate dateUpdate, @NotBlank String cpf) {
}
