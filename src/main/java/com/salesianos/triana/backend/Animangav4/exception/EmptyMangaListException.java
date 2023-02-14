package com.salesianos.triana.backend.Animangav4.exception;

import javax.persistence.EntityNotFoundException;

public class EmptyMangaListException extends EntityNotFoundException {

    public EmptyMangaListException() {
        super("No mangas were found with the search criteria");
    }


}