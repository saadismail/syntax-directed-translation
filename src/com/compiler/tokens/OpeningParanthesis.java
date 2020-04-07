package com.compiler.tokens;

public class OpeningParanthesis extends Token {
    public OpeningParanthesis() {
        super("(");
    }

    @Override
    public String getASMCode() {
        return "";
    }
}
