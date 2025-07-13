package com.example.photocatalog.service;

import com.example.photocatalog.domain.Photo;

import java.util.List;
import java.util.UUID;

public interface PhotoService {

    List<Photo> allPhotos();

    Photo photoByDescription(String description);

    Photo byId(UUID id);
}
