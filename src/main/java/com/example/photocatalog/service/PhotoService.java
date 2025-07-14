package com.example.photocatalog.service;

import com.example.photocatalog.domain.Photo;
import com.example.photocatalog.domain.graphql.PhotoGQL;
import com.example.photocatalog.domain.graphql.PhotoInputGQL;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.UUID;

public interface PhotoService {

    List<Photo> allPhotos();

    Slice<PhotoGQL> gqlAllPhotos(Pageable pageable);

    Photo photoByDescription(String description);

    Photo byId(UUID id);

    PhotoGQL gqlAddPhoto(PhotoInputGQL input);

    Photo addPhoto(Photo photo);

    PhotoGQL gqlById(UUID id);
}
