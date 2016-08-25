import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class bianma {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        getmd5();
    }

    private static void base64() {
        byte[] bytes = "我很帅".getBytes();
        String encode = new BASE64Encoder().encode(bytes);
        System.out.print(encode);
        byte[] bytes1 = new byte[0];
        try {
            bytes1 = new BASE64Decoder().decodeBuffer(encode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = new String(bytes1);
        System.out.print(s);
    }

    //消息摘要
    //对一个消息进行当项Hash加密函数

    //MD 消息摘要算法
    //SHA 安全散列算法
    //MAC 消息认证码算法
    //用于验证消息的完整性，防止数据在传输中篡改的问题
    private static void md5() {
        String str = "我很帅";
        byte[] bytes = str.getBytes();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes);
            byte[] digest = md5.digest();
            String s = new String(digest);
            System.out.print(digest.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //获取文件的md5
    private static void getmd5() throws IOException, NoSuchAlgorithmException {
        String path = "C:\\Users\\Administrator\\Desktop\\gaode_city.json";
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        DigestInputStream dis = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
        byte[] bytes = new byte[1024];
        int read = dis.read(bytes);
        while (read != -1) {
            read = dis.read(bytes, 0, 1024);
        }
        MessageDigest messageDigest = dis.getMessageDigest();
        byte[] digest = messageDigest.digest();
        System.out.print(digest.toString());
    }


}
