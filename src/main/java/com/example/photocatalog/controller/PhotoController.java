package com.example.photocatalog.controller;

import com.example.photocatalog.domain.Photo;
import com.example.photocatalog.ex.PhotoNotFoundException;
import com.example.photocatalog.service.PhotoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public Photo byId(@PathVariable("id") UUID id) {
        return photoService.byId(id);
    }
}
