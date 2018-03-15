package stroe.devin.com.devinandroiddemo.utils;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by zengxiaowen on 2018/2/6.
 */

public class ToolPassEncry {

    /**
     * @param pwdStr
     * @return
     * @category 密码加密
     */
    public static String YLPWDEncrypt(String pwdStr) {

        byte[] _appkey = getAppKey("f8fbcc51c6ef474b9095dd0cfecb2971");
        SecretKey deskey = new SecretKeySpec(_appkey, "DESede");
        try {
            Cipher cp = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cp.init(1, deskey);
            byte[] byteResul = cp.doFinal(pwdStr.getBytes());
            return byte2Base64(byteResul);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static String byte2Base64(byte[] byteResul) {
        // TODO Auto-generated method stub
        Base64Encoder encoder = new Base64Encoder();
        String baseStr = encoder.encode(byteResul);
        return baseStr;
    }

    private static byte[] getAppKey(String key) {
        // TODO Auto-generated method stub

        byte[] bkey = key.getBytes();
        int start = (bkey.length > 24) ? 24 : bkey.length;
        byte[] bkey24 = new byte[24];
        for (int i = 0; i < start; ++i) {
            bkey24[i] = bkey[i];
        }
        for (int i = start; i < 24; ++i) {
            bkey24[i] = bkey[(i - start)];
        }
        return bkey24;
    }

}
