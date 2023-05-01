package pro.sky.telegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.entity.Cat;
import pro.sky.telegrambot.entity.Dog;
import pro.sky.telegrambot.service.CatService;

import java.util.Optional;

@RestController
@RequestMapping("cat")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {this.catService = catService;}

    @Operation(
            summary = "Добавляет кота в БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот добавлен в БД.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            },
            tags = "Cats"
    )
    @PostMapping
    public Cat createDog(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @Operation(
            summary = "Обновляет информацию о коте в БД.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот найден в БД и обновлена информация о нем",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            },
            tags = "Cats"
    )
    @PutMapping
    public Cat editCat(@RequestBody Cat cat) {
        return catService.editCat(cat);
    }

    @Operation(
            summary = "Показывает информацию о коте",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Получена информация о коте из БД",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Кот не найден в БД."
                    )
            },
            tags = "Cats"
    )

    @GetMapping("{id}")
    public Optional<Cat> getCat(@Parameter(description = "ID кота") @PathVariable long id) {
        return catService.getCat(id);
    }

    @Operation(
            summary = "Удаляет кота из БД",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот удален из БД",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Кот не найден в БД."
                    )
            },
            tags = "Cats"
    )
    @DeleteMapping
    public void deleteCat(@PathVariable long id) {
        catService.deleteCat(id);
    }
}
