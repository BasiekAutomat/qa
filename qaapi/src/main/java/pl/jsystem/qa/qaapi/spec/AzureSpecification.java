package pl.jsystem.qa.qaapi.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static pl.jsystem.qa.qaapi.config.ApiConfig.AZURE_BASE_URI;

public class AzureSpecification {

    private static final String BASE_PATH = "/api/v1";

    public static RequestSpecification azureSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "ApiKey")
                .setBaseUri(AZURE_BASE_URI)
                .setBasePath(BASE_PATH)
                .build();
    }
}