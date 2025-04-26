package bai1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class PasswordUtil {
	public static String hashSHA(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
	
	

}
