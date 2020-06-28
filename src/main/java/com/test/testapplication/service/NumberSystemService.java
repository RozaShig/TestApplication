package com.test.testapplication.service;

import com.test.testapplication.params.NumberSystemParams;
import org.springframework.stereotype.Service;

@Service
public class NumberSystemService {

    private static final char[] DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String getFromDec(NumberSystemParams params) {
        StringBuilder result = new StringBuilder();
        int number = params.getNumber(), base = params.getBase();
        do {
            result.append(DIGITS[number % base]);
            number = number / base;
        } while (number != 0);
        return result.reverse().toString();
    }
}
