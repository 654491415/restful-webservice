package javax.core.common.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

public class DESStaticKey {

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param keys
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data,String keys) throws Exception {
        byte[] bt = encrypt(data.getBytes(), keys.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param keys
     *            加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data,String keys) throws IOException, Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, keys.getBytes());
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception  {
        String data ="[{\"eirId\":9947054,\"eirNo\":\"201807121032\",\"deliveryno\":\"SUNHUM18002661\",\"printDate\":1531728543771,\"printUser\":\"打印人1号\",\"printNum\":1,\"boxCarrierId\":\"DGSCPWKWLYXGS\",\"boxCarrierName\":\"拖车行\",\"payStatus\":\"1\",\"receiptSender\":\"PORTPORT\"}]";


        System.out.println("加密   "+DESStaticKey.encrypt(data,"eca82edd7804cbfa78664dc5884c18efac514328acd785354ec8ced17fc0f824ae3a8f8c4ac3b48046522fd7205bf9de5397276a0678"));
//     String  str="n9N4zXkxfMI0sHNGWEdtropSFfIjjC3g/XS0ADqBPmDjaeQzWQ7TEK0pNouo/Q4GfY+aDfT/8B3bd/S5zRDXblIqMEaC0edNtAoZUx01AzlPZ9vGFxajv7TyPd4IJI8F2183c1hhk42UgErbko97dk3L912sGt55TWUW9NMnKYj0hqQYkNa0brujyTBwjHQ3NAhpK8FmGeEDPZzBCkYruSuo0zw9yapcbedeW4PZh2vGFOSR4WiYhC0L39a/W7iat8sY3B6Is0iKBVvRRZUI8fy4OSUBfZx9wh1D9eHcQ/TDXkqLHBgIj2mLyqN5GWdTUO5f2tKdUSQ=";
//        System.out.println("解密：" + DESStaticKey.decrypt(str,"eca82edd7804cbfa78664dc5884c18efac514328acd785354ec8ced17fc0f824ae3a8f8c4ac3b48046522fd7205bf9de5397276a0678"));



    }

}
