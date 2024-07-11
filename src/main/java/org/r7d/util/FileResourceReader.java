package org.r7d.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;

@UtilityClass
public class FileResourceReader {


    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static <T> T readResource(String fileName, TypeReference<T> typeReference) {
        try (InputStream inputStream = FileResourceReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + fileName);
            }
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource from file: " + fileName, e);
        }
    }
}
