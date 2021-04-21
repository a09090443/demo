package com.example.util;

import com.example.base.TestBase;
import com.zipe.util.crypto.Base64Util;
import com.zipe.util.crypto.CryptoUtil;
import org.junit.jupiter.api.Test;

public class CryptoTest extends TestBase {

    @Test
    public void base64Test(){
        CryptoUtil base64 = new CryptoUtil(new Base64Util());
        String encode = base64.encrypt("test");
        System.out.println(encode);
        String decode = base64.decode(encode);
        System.out.println(decode);
    }
}
