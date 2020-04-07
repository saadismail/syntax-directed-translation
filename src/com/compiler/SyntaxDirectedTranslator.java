package com.compiler;

import com.compiler.tokens.Token;

import java.util.List;

public class SyntaxDirectedTranslator {
    List<Token> parsedTokens;

    public SyntaxDirectedTranslator(List<Token> parsedTokens) {
        this.parsedTokens = parsedTokens;
    }

    public String parseExpr() {
        return parseTerm() + "\n" + parseExprBar();
    }

    private String parseExprBar() {
        if (parsedTokens.size() == 0) return "";

        Token token = parsedTokens.get(0);

        switch(token.getValue()) {
            case "+":
            case "-":
                parsedTokens.remove(0);
                return parseTerm() + "\n" + parseExprBar() + "\n" + token.getASMCode();
            default:
                return "";
        }
    }

    private String parseTerm() {
        return parseFactor() + "\n" + parseTermBar();
    }

    private String parseTermBar() {
        if (parsedTokens.size() == 0) return "";

        Token token = parsedTokens.get(0);

        switch(token.getValue()) {
            case "*":
            case "/":
            case "%":
                parsedTokens.remove(0);
                return parseFactor() + "\n" + parseTermBar() + "\n" + token.getASMCode();
            default:
                return "";
        }
    }

    private String parseFactor() {
        Token token = parsedTokens.get(0);

        switch (token.getValue()) {
            case "(":
                parsedTokens.remove(0);
                String output = parseExpr();
                parsedTokens.remove(0);
                return output;
            default:
                // Number here
                parsedTokens.remove(0);
                return token.getASMCode();
        }
    }
}
