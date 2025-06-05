package springboot.dtos;

import org.hibernate.validator.constraints.NotBlank;

public record VehicleRecordDto(@NotBlank String plate, @NotBlank String model, @NotBlank String currentLocalization) {
}
