package com.salesianos.triana.backend.Animangav4.service;

import com.salesianos.triana.backend.Animangav4.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MangaService {

    private final MangaRepository repository;


}
