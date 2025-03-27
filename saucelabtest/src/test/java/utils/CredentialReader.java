package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CredentialReader {

    static final String CREDENTIALS_PATH = "src/test/resources/credentials.json";

    public static Credential readCredential() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = Paths.get(CREDENTIALS_PATH).toFile();
            return mapper.readValue(file, Credential.class);
        } catch (IOException e) {
            throw new RuntimeException("Could not read credentials from credential.json", e);
        }
    }

}
