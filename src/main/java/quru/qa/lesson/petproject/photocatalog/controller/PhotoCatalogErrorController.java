package quru.qa.lesson.petproject.photocatalog.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/error")
public class PhotoCatalogErrorController extends AbstractErrorController {

    public PhotoCatalogErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes, Collections.emptyList());
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> errorAttributes = this.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        return new ResponseEntity<>(errorAttributes, status);
    }
}
