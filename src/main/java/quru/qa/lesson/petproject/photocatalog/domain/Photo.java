package quru.qa.lesson.petproject.photocatalog.domain;

import java.util.Date;
import java.util.UUID;

public record Photo(UUID id,
                    String description,
                    Date lastModifyDate,
                    String content) {
}
