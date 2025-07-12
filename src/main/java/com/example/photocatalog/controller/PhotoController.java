package com.example.photocatalog.controller;

import com.example.photocatalog.domain.Photo;
import com.example.photocatalog.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/photo")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/all")
    public List<Photo> all() {
        return photoService.allPhotos();
    }

}
