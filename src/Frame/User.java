package Frame;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class User {
    public static ArrayList<User> users= new ArrayList<>();
    public static HashMap<String,User>hashMap= new HashMap<>();
    public String id;
    public String encryptedData;
    public String encryptedID;
    public byte[] salt;
    static int a=0;
    static byte[] b;
    public User(String id){
        this.id=id;
//        try {
//            salt=getSalt();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        String key=getSecurePassword(password,salt);
//        encryptedID=AES.encrypt(id,key);
//        encryptedData=AES.encrypt(data,key);
    }
    public boolean checkUser(String password){
        String key=getSecurePassword(password,salt);
        if(id.equals(AES.decrypt(encryptedID,key))){
            return true;
        }
        return false;
    }
    public void changeData(String password,String data){
        String key=getSecurePassword(password,salt);
        encryptedData=AES.encrypt(data,key);

    }
    public String readData(String password){
        String key=getSecurePassword(password,salt);
        return AES.decrypt(encryptedData,key);
    }
    public static String getSecurePassword(String password, byte[] salt) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        System.out.println("new salt");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
