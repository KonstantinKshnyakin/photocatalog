package quru.qa.lesson.petproject.photocatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quru.qa.lesson.petproject.photocatalog.domain.Photo;
import quru.qa.lesson.petproject.photocatalog.service.PhotoService;

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
