package utils.APItest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
