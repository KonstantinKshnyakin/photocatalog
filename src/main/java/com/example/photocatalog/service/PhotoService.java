package com.example.photocatalog.service;

import com.example.photocatalog.domain.Photo;

import java.util.List;

public interface PhotoService {

    List<Photo> allPhotos();

    Photo photoByDescription(String description);
}
