import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class bianma {
    public static void main(String[] args) throws Exception {
        hmac();
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

    private static void sha() throws NoSuchAlgorithmException {
        String str = "我很帅";
        byte[] bytes = str.getBytes();
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(bytes);
        byte[] digest = sha.digest();
        System.out.print(digest);
    }

    //md5和sha的缺点 当客户单发送数据 一个data和disge 如果都被截获，被构造一份data和相应的disge是有问题的
    //hmac 读disget进行加密 所以要对disget进行解密所以比上着根号用


    private static void hmac() throws Exception {
        String str = "我很帅";
        //生成秘钥
        KeyGenerator hmacMD5 = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = hmacMD5.generateKey();
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "HmacMD5");
        Mac mac = Mac.getInstance("HmacMd5");
        mac.init(secretKeySpec);
        byte[] bytes = mac.doFinal(str.getBytes());
        System.out.print(bytes.toString());
    }
}
