package quru.qa.lesson.petproject.photocatalog.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;
import quru.qa.lesson.petproject.photocatalog.domain.ApiError;

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
