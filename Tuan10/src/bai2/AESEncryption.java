package bai2;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AESEncryption implements Encryptable  {
	private static final String key = "1234567890123456"; // 16 bytes key
    private static final String algorithm = "AES";

    @Override
    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    @Override
    public String decrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(decrypted);
    }

}
