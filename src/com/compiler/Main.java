package com.compiler;

import com.compiler.tokens.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String expression = scanner.nextLine();

//        String expression = "22          *   (50 + (36 / 12)                   - 16)";

        String expression = "2 + 3";

        List<Token> parsedTokens = new Parser(expression).parseExpression();
        String translatedCode = new SyntaxDirectedTranslator(parsedTokens).parseExpr();
        System.out.println(translatedCode);
    }

}
