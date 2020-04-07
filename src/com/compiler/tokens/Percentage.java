package com.compiler.tokens;

public class Percentage extends Token {
    public Percentage() {
        super("%");
    }

    @Override
    public String getASMCode() {
        return "POP AX\n" +
                "POP BX\n" +
                "MOV DX, 0\n" +
                "DIV BX\n" +
                "PUSH DX\n";
    }
}
