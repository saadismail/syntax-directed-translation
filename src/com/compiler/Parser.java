package com.compiler;

import com.compiler.tokens.*;
import com.compiler.tokens.Number;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String expression;

    public Parser(String expression) {
        this.expression = expression;
    }

    public List<Token> parseExpression() {
        List<Token> result = new ArrayList<>();
        expression = expression.trim().replace(" ", "");

        for (int index = 0; index < expression.length(); index++) {
            char c = expression.charAt(index);
            if (Character.isDigit(c)) {
                index = parseInteger(result, index);
            } else if (c == '+') result.add(new Plus());
            else if (c == '-') result.add(new Minus());
            else if (c == '*') result.add(new Multiply());
            else if (c == '/') result.add(new Divide());
            else if (c == '(') result.add(new OpeningParanthesis());
            else if (c == ')') result.add(new ClosingParanthesis());
            else if (c == '%') result.add(new Modulo());
        }

        return result;
    }

    private int parseInteger(List<Token> result, int index) {
        StringBuilder number = new StringBuilder();

        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
            number.append(expression.charAt(index));
            index++;
        }
        result.add(new Number(number.toString()));
        return --index;
    }
}
