package com.compiler.tokens;

public class Minus extends Token {
    public Minus() {
        super("-");
    }

    @Override
    public String getASMCode() {
        return "POP AX\n" +
                "POP BX\n" +
                "SUB AX, BX\n" +
                "PUSH AX\n";
    }
}
