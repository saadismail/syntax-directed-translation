package com.compiler.tokens;

public class Divide extends Token {
    public Divide() {
        super("/");
    }

    @Override
    public String getASMCode() {
        return "POP AX\n" +
                "POP BX\n" +
                "MOV DX, 0\n" +
                "DIV BX\n" +
                "PUSH AX\n";
    }
}