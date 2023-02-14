package com.salesianos.triana.backend.Animangav4.service;

import com.salesianos.triana.backend.Animangav4.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

}
