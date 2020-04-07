package com.compiler.tokens;

public class Divide extends Token {
    public Divide() {
        super("/");
    }

    @Override
    public String getASMCode() {
        return "POP BX\n" +
                "POP AX\n" +
                "MOV DX, 0\n" +
                "DIV BX\n" +
                "PUSH AX\n";
    }
}
