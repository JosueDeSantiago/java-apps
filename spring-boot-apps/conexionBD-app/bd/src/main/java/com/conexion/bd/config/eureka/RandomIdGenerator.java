package com.conexion.bd.config.eureka;

import java.security.SecureRandom;
import java.util.Objects;

public class RandomIdGenerator {

    private final SecureRandom random;

    private static final char[] SYMBOLS = {'a','b','c','d','e','f','g','h','i',
                                           'j','k','l','m','n','o','p','q','r',
                                           's','t','u','v','w','x','y','z','0',
                                           '1','2','3','4','5','6','7','8','9'};

    private final char[] buf;

    public String nextString() {
        for (int i = 0; i < buf.length; ++i) {
            buf[i] = SYMBOLS[random.nextInt(SYMBOLS.length)];
        }

        return new String(buf);
    }

    public RandomIdGenerator(int length) {
        this.random = Objects.requireNonNull(new SecureRandom());
        this.buf = new char[length];
    }

}