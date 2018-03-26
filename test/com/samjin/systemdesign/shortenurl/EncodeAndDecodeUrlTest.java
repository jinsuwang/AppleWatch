package com.samjin.systemdesign.shortenurl;

import org.junit.Test;

import static org.junit.Assert.*;

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