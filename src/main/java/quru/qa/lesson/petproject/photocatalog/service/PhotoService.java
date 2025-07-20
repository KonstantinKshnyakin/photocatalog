package quru.qa.lesson.petproject.photocatalog.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import quru.qa.lesson.petproject.photocatalog.domain.Photo;
import quru.qa.lesson.petproject.photocatalog.domain.graphql.PhotoGQL;
import quru.qa.lesson.petproject.photocatalog.domain.graphql.PhotoInputGQL;

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
