package org.example.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class SecurityProvider {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = System.getProperty("key").getBytes();
    private static Key key;

    public static void main(String args[]) throws Exception {
        String encryptedValue = encrypt("locked_out_user");
        System.out.println("Encrypted value: " + encryptedValue);
        System.out.println(decrypt(encryptedValue));
    }

    public static String encrypt(String valueToEnc) throws Exception {
        key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        //encrypt
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        //encode
        byte[] encryptedByteValue = Base64.getEncoder().encode(encValue);
        return new String(encryptedByteValue);
    }

    public static String decrypt(String encryptedValue) {
        byte[] decrypted = null;
        try {
            key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            //decode
            byte[] decoded = Base64.getDecoder().decode(encryptedValue);
            //decrypt
            decrypted = c.doFinal(decoded);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String(decrypted);
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
