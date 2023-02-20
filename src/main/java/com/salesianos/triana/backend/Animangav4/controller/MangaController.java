package com.salesianos.triana.backend.Animangav4.controller;


import com.salesianos.triana.backend.Animangav4.dtos.CreateMangaDto;
import com.salesianos.triana.backend.Animangav4.dtos.GetMangaDto;
import com.salesianos.triana.backend.Animangav4.dtos.MangaDtoConverter;
import com.salesianos.triana.backend.Animangav4.models.Manga;
import com.salesianos.triana.backend.Animangav4.models.User;
import com.salesianos.triana.backend.Animangav4.service.MangaService;
import com.salesianos.triana.backend.Animangav4.utils.PaginationLinksUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manga")


public class MangaController {
    private final MangaService mangaService;
    private final MangaDtoConverter mangaDtoConverter;
    private final PaginationLinksUtils paginationLinksUtils;
    @Operation(summary = "Listar todos los mangas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se devuelve una lista con todos los mangas",
                    content = {@Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = Manga.class))}),
            @ApiResponse(responseCode = "404",
                    description = "La lista esta vacia",
                    content = @Content),
    })
    @GetMapping("/all")
    public ResponseEntity<Page<GetMangaDto>> findAllMangas (@PageableDefault(size = 10, page = 0) Pageable pageable,
                                                            @AuthenticationPrincipal User user,
                                                            @NotNull HttpServletRequest request) {
        Page<GetMangaDto> list = mangaService.findAllMangas(pageable);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
        return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(list, uriBuilder)).body(list);
    }

    @Operation(summary = "Crea un Manga")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Si se crea el manga correctamente",
                    content = {@Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = Manga.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Error en los datos",
                    content = @Content),
    })
    @PostMapping("/new")
    public ResponseEntity<GetMangaDto> createManga(@Valid @RequestPart("manga") CreateMangaDto c,
                                                 @RequestPart("file") MultipartFile file,
                                                 @AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mangaDtoConverter.mangaToGetMangaDto(mangaService.save(c, file, user)));
    }

}
