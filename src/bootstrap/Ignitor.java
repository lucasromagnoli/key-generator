package bootstrap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author github.com/lucasromagnoli
 * @since 03/02/2020
 */
public class Ignitor {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            OutputStream outputStream = null;
            try {
                System.out.println("Private key format: " + keyPair.getPrivate().getFormat());
                outputStream = new FileOutputStream("private.key");
                outputStream.write(keyPair.getPrivate().getEncoded());
                outputStream.close();

                System.out.println("Public key format: " + keyPair.getPublic().getFormat());
                outputStream = new FileOutputStream("public.key");
                outputStream.write(keyPair.getPublic().getEncoded());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            };
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
