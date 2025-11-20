package com.numberservice.numstream.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Запрос на сохранение числа")
public class NumberRequest {

    @NotNull(message = "Значение не может быть null")
    @Schema(description = "Целое число для сохранения", example = "42")
    private Integer value;
}