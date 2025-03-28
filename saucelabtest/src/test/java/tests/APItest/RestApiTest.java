package tests.APItest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import utils.User;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestApiTest {

    @Test
    public void testGetUsersAndLogEmails() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/users")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertTrue(response.isSuccessful(), "Erroneous response!");

            String json = response.body().string();

            ObjectMapper mapper = new ObjectMapper();
            List<User> users = mapper.readValue(json, new TypeReference<List<User>>() {
            });

            // Logging
            for (User user : users) {
                System.out.println(user.getName() + " | " + user.getEmail());
            }

            // Assert
            String firstEmail = users.get(0).getEmail();
            assertTrue(firstEmail.contains("@"), "The first mail does not contain @ jelet!");
        }
    }
}
