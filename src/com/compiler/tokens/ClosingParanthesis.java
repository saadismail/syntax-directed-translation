package com.compiler.tokens;

public class ClosingParanthesis extends Token {
    public ClosingParanthesis() {
        super(")");
    }

    @Override
    public String getASMCode() {
        return "";
    }
}
