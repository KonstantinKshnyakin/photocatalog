package com.example.photocatalog.service;

import com.example.photocatalog.db.PhotoEntity;
import com.example.photocatalog.db.PhotoRepository;
import com.example.photocatalog.domain.Photo;
import com.example.photocatalog.domain.graphql.PhotoGQL;
import com.example.photocatalog.domain.graphql.PhotoInputGQL;
import com.example.photocatalog.ex.PhotoNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public Page<PhotoGQL> gqlAllPhotos(Pageable pageable) {
        return photoRepository.findAll(pageable)
            .map(pe -> new PhotoGQL(
                pe.getId(),
                pe.getDescription(),
                pe.getLastModifyDate(),
                pe.getContent() != null ? new String(pe.getContent()) : ""
            ));
    }

    @Override
    public Photo photoByDescription(String description) {
        return null;
    }

    @Override
    public Photo byId(UUID id) {
        return photoRepository.findById(id)
            .map(pe -> new Photo(
                pe.getDescription(),
                pe.getLastModifyDate(),
                pe.getContent() != null ? new String(pe.getContent()) : ""
            ))
            .orElseThrow(() -> new PhotoNotFoundException("das"));
    }

    @Override
    public PhotoGQL gqlAddPhoto(PhotoInputGQL input) {
        PhotoEntity pe = new PhotoEntity();
        pe.setContent(input.content().getBytes(StandardCharsets.UTF_8));
        pe.setDescription(input.description());
        pe.setLastModifyDate(new Date());
        PhotoEntity saved = photoRepository.save(pe);
        return new PhotoGQL(
            saved.getId(),
            saved.getDescription(),
            saved.getLastModifyDate(),
            new String(saved.getContent())
        );
    }

    @Override
    public Photo addPhoto(Photo photo) {
        return null;
    }

    @Override
    public PhotoGQL gqlById(UUID id) {
        return photoRepository.findById(id)
            .map(pe -> new PhotoGQL(
                pe.getId(),
                pe.getDescription(),
                pe.getLastModifyDate(),
                pe.getContent() != null ? new String(pe.getContent()) : ""
            ))
            .orElseThrow(() -> new PhotoNotFoundException("das"));
    }
}
