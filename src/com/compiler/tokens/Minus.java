package com.compiler.tokens;

public class Minus extends Token {
    public Minus() {
        super("-");
    }

    @Override
    public String getASMCode() {
        return "POP BX\n" +
                "POP AX\n" +
                "SUB AX, BX\n" +
                "PUSH AX\n";
    }
}
