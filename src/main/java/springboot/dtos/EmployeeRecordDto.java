package springboot.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeRecordDto(@NotBlank UUID id, @NotBlank String name, @NotBlank String login, @NotBlank String password, @NotBlank String email, @NotBlank
LocalDate dateCreation, LocalDate dateUpdate, @NotBlank String badgeNumber, @NotBlank double salary) {
}

