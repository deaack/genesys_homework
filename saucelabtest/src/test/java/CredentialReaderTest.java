
import org.junit.jupiter.api.Test;

public class CredentialReaderTest {

    @Test
    public void testReadCredential() {
        Credential credential = CredentialReader.readCredential();

        System.out.println("Username: " + credential.getUsername());
        System.out.println("Password: " + credential.getPassword());

        assert credential.getUsername() != null;
        assert credential.getPassword() != null;
    }
}
