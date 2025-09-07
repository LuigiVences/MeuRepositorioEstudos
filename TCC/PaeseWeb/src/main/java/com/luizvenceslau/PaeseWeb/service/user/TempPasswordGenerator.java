package com.luizvenceslau.PaeseWeb.service.user;

import java.security.SecureRandom;

public class TempPasswordGenerator {

    private static final SecureRandom randon = new SecureRandom();

    public static String generateNumericPassword(){
        var number = randon.nextInt(900000) + 100000;
        return String.valueOf(number);
    }
}
