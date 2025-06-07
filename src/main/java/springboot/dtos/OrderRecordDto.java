package springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record OrderRecordDto(@NotBlank String recipientCPF,
                             @NotBlank String status,
                             @NotBlank String address,
                             String vehiclePlate) {
}
