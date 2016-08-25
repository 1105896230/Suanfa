import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class bianma {
    public static void main(String[] args) {
        base64();
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
}
