package com.compiler.tokens;

import java.util.Objects;

abstract public class Token {
    protected String value;
    public String userFriendlyType = "Operator";

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract String getASMCode();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Token{" + value + '}';
    }
}
