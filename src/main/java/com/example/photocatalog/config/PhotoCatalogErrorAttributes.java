package com.example.photocatalog.config;

import com.example.photocatalog.domain.ApiError;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class PhotoCatalogErrorAttributes extends DefaultErrorAttributes {

    private final String apiVersion;

    public PhotoCatalogErrorAttributes(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        ApiError apiError = ApiError.fromAttributeMap(apiVersion, errorAttributes);
        return apiError.toAttributeMap();
    }
}
