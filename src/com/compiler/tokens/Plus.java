package com.compiler.tokens;

public class Plus extends Token {

    public Plus() {
        super("+");
    }

    @Override
    public String getASMCode() {
        return "POP AX\n" +
                "POP BX\n" +
                "ADD AX, BX\n" +
                "PUSH AX\n";
    }
}
