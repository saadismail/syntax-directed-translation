package com.compiler.tokens;

public class Number extends Token {

    public Number(String value) {
        super(value);
        Integer.parseInt(value);
    }

    @Override
    public String getASMCode() {
        return ("MOV AX, Number\n" +
                "PUSH AX\n").replace("Number", this.value);
    }
}
