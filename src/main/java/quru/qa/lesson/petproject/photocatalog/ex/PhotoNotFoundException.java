package quru.qa.lesson.petproject.photocatalog.ex;

public class PhotoNotFoundException extends RuntimeException{

    public PhotoNotFoundException() {
    }

    public PhotoNotFoundException(String message) {
        super(message);
    }
}
