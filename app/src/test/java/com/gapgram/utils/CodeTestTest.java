package com.gapgram.utils;

import junit.framework.TestCase;

public class CodeTestTest extends TestCase {

    public void testSum() {
        CodeTest codeTest=new CodeTest();
        int code=codeTest.sum(2,2);
        assertEquals(8,code);
    }
}