package com.compiler.tokens;

public class Multiply extends Token {
    public Multiply() {
        super("*");
    }

    @Override
    public String getASMCode() {
        return "POP AX\n" +
                "POP BX\n" +
                "MUL BX\n" +
                "PUSH AX\n";
    }
}
