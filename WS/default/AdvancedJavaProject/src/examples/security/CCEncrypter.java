package examples.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CCEncrypter {
    private static final String algorithm = "DESede";
    private static Key key;
    private static Cipher cipher;
    static {
        try {
            String ssp = "The SuperSecret Password";
            key = new SecretKeySpec(ssp.getBytes(),
                    algorithm);
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            String msg = 
                "Unable to initialize CCEncrypter";
            System.err.println(msg);
            e.printStackTrace();
        } 
    }
    
    public static String decrypt(byte data []) throws
            Exception {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data));
    }
    
    public static byte [] encrypt(String data) throws 
            Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
}