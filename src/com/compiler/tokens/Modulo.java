package com.compiler.tokens;

public class Modulo extends Token {
    public Modulo() {
        super("%");
    }

    @Override
    public String getASMCode() {
        return "POP BX\n" +
                "POP AX\n" +
                "MOV DX, 0\n" +
                "DIV BX\n" +
                "PUSH DX\n";
    }
}
