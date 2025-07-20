package quru.qa.lesson.petproject.photocatalog.config;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quru.qa.lesson.petproject.photocatalog.domain.ApiError;
import quru.qa.lesson.petproject.photocatalog.ex.PhotoNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Value("${api.version}")
    private static String apiVersion;

    @ExceptionHandler(PhotoNotFoundException.class)
    public ResponseEntity<Object> handlePhotoNotFoundException(PhotoNotFoundException ex, HttpServletRequest request) {
        LOG.error(request.getRequestURI(), ex);
        return new ResponseEntity<>(
            new ApiError(
                apiVersion,
                HttpStatus.NOT_FOUND.toString(),
                "Photo not found",
                request.getRequestURI(),
                ex.getMessage()
            ),
            HttpStatus.NOT_FOUND
        );
    }
}
