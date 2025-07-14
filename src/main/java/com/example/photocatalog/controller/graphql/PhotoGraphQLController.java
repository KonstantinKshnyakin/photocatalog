package com.example.photocatalog.controller.graphql;

import com.example.photocatalog.domain.graphql.PhotoGQL;
import com.example.photocatalog.domain.graphql.PhotoInputGQL;
import com.example.photocatalog.service.PhotoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class PhotoGraphQLController {

    private final PhotoService photoService;

    public PhotoGraphQLController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @QueryMapping
    public Slice<PhotoGQL> photos(@Argument("page") int page, @Argument("size") int size) {
        return photoService.gqlAllPhotos(PageRequest.of(page, size));
    }

    @QueryMapping
    public PhotoGQL photo(@Argument("id") UUID id) {
        return photoService.gqlById(id);
    }

    @MutationMapping
    public PhotoGQL addPhoto(@Argument("input") PhotoInputGQL input) {
        return photoService.gqlAddPhoto(input);
    }
}
