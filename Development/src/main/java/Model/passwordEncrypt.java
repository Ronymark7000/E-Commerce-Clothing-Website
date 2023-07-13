package Model;

//Model page for Password Encryption 

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import javax.crypto. Cipher;
import javax. crypto. spec. SecretKeySpec;
import java. nio.charset. StandardCharsets;
import java.security. Key;

public class passwordEncrypt{

    private static final String algo = "AES";



/*

Encrypts a string using a secure key

*/

    public static String encrypt(String strToEncrypt, String secretKey) throws Exception {

        Key key = generateKey(secretKey);
        
        Cipher cipher = Cipher.getInstance ("AES/ECB/PKCS5Padding");
        
        cipher. init (Cipher.ENCRYPT_MODE, key);
        
        byte[]encryptedBytes = cipher. doFinal(strToEncrypt. getBytes(StandardCharsets.UTF_8)) ;
        
        return new String(encryptedBytes, StandardCharsets.ISO_8859_1) ;
    }

/*

Decrypts an encrypted string using a secure key

I

*/

public static String decrypt (String strToDecrypt, String secretKey) throws Exception {

        Key key = generateKey(secretKey);
    
        Cipher cipher = Cipher.getInstance ("AES/ECB/PKCS5Padding");
    
        cipher. init (Cipher. DECRYPT_MODE, key);
        
        byte[] decryptedBytes = cipher.doFinal(strToDecrypt.getBytes (StandardCharsets.ISO_8859_1)) ;
    
        return new String (decryptedBytes, StandardCharsets.UTF_8) ;
    }
    private static Key generateKey(String secretKey)
    {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec (keyBytes, algo);
}
}