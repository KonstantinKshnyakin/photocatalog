package com.example.photocatalog.domain.graphql;

import java.util.Date;
import java.util.UUID;

public record PhotoGQL(UUID id,
                       String description,
                       Date lastModifyDate,
                       String content) {
}
