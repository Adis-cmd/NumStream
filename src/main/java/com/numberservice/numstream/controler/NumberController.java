package com.numberservice.numstream.controler;

import com.numberservice.numstream.dto.NumberRequest;
import com.numberservice.numstream.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Tag(name = "Number Controller", description = "API для работы с числами")
public class NumberController {

    private final NumberService numberService;

    @Operation(
            summary = "Сохранение числа",
            description = "Сохраняет переданное число и возвращает список всех сохраненных чисел"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Число успешно сохранено",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = List.class),
                            examples = @ExampleObject(
                                    value = "[1, 5, 10, 42]"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некорректный запрос (ошибка валидации)",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PostMapping("/numbers")
    public List<Integer> saveNumber(
            @Parameter(
                    description = "Объект с числом для сохранения",
                    required = true,
                    schema = @Schema(implementation = NumberRequest.class)
            )
            @RequestBody @Valid NumberRequest request
    ) {
        return numberService.saveNumber(request.getValue());
    }
}