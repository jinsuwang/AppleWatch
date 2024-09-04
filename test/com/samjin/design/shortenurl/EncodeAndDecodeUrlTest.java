package com.samjin.design.shortenurl;

import com.samjin.hashmap.EncodeAndDecodeUrl;
import org.junit.Test;

public class EncodeAndDecodeUrlTest {

    EncodeAndDecodeUrl ins = new EncodeAndDecodeUrl();

    @Test
    public void encode() {
        System.out.println(ins.encode("http://apple.com"));
    }

    @Test
    public void decode() {
        ins.encode("http://apple.com");
        System.out.println(ins.decode("b"));
    }
}