package quru.qa.lesson.petproject.photocatalog.service;

import com.google.protobuf.util.Timestamps;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import quru.qa.lesson.petproject.photocatalog.domain.Photo;
import quru.qa.lesson.petproject.photocatalog.grpc.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class GrpcPhotoService extends PhotocatalogServiceGrpc.PhotocatalogServiceImplBase {

    private static final Random random = new Random();
    private final PhotoService photoService;

    public GrpcPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Override
    public void addPhoto(PhotoRequest request, StreamObserver<PhotoResponse> responseObserver) {
        Photo photo = photoService.addPhoto(
            new Photo(
                null,
                request.getDescription(),
                null,
                request.getContent()
            )
        );
        responseObserver.onNext(mapProto(photo));
        responseObserver.onCompleted();
    }

    @Override
    public void photo(IdRequest request, StreamObserver<PhotoResponse> responseObserver) {
        Photo photo = photoService.byId(UUID.fromString(request.getId()));
        responseObserver.onNext(mapProto(photo));
        responseObserver.onCompleted();
    }

    @Override
    public void randomPhotos(CountRequest request, StreamObserver<PhotoResponse> responseObserver) {
        List<Photo> photos = photoService.allPhotos();
        for (int i = 0; i < request.getCount(); i++) {
            Photo photo = photos.get(random.nextInt(photos.size()));
            responseObserver.onNext(mapProto(photo));
        }
        responseObserver.onCompleted();
    }

    private PhotoResponse mapProto(Photo photo) {
        return PhotoResponse.newBuilder()
            .setId(photo.id().toString())
            .setDescription(photo.description())
            .setLastModifyDate(Timestamps.fromDate(photo.lastModifyDate()))
            .setContent(photo.content())
            .build();
    }
}
