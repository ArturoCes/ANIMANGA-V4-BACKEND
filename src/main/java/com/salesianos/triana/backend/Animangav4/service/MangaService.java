package com.salesianos.triana.backend.Animangav4.service;

import com.salesianos.triana.backend.Animangav4.dtos.GetMangaDto;
import com.salesianos.triana.backend.Animangav4.dtos.MangaDtoConverter;
import com.salesianos.triana.backend.Animangav4.exception.EmptyMangaListException;
import com.salesianos.triana.backend.Animangav4.models.Manga;
import com.salesianos.triana.backend.Animangav4.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MangaService {

    private final MangaRepository repository;
    private final MangaDtoConverter mangaDtoConverter;


    public Page<GetMangaDto> findAllMangas(Pageable pageable) {
        Page<Manga> lista = repository.findAll(pageable);

        if (lista.isEmpty()) {
            throw new EmptyMangaListException(Manga.class);
        } else {
            return lista.map(mangaDtoConverter::mangaToGetMangaDto);
        }
    }


}
