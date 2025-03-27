//Credentail to be insatanced
public class Credential {
    private String username;
    private String password;

    // for Jackson....
    public Credential() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credential{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
