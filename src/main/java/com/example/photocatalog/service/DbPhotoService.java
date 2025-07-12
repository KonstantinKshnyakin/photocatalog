package com.example.photocatalog.service;

import com.example.photocatalog.db.PhotoRepository;
import com.example.photocatalog.domain.Photo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DbPhotoService implements PhotoService{

    private final PhotoRepository photoRepository;

    public DbPhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> allPhotos() {
        return photoRepository.findAll().stream()
            .map(pe -> new Photo(
                pe.getDescription(),
                pe.getLastModifyDate(),
                pe.getContent() != null ? new String(pe.getContent()) : ""
            )).toList();
    }

    @Override
    public Photo photoByDescription(String description) {
        return null;
    }
}
