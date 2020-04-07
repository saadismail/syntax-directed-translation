package com.compiler;

import com.compiler.tokens.Token;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("/?")) {
            System.out.println("Eval <<expression>>");
            return;
        }

        StringBuilder expression = getExpression(args);

        List<Token> parsedTokens = new Parser(expression.toString()).parseExpression();
        printParsedTokens(parsedTokens);

        String translatedCode = new SyntaxDirectedTranslator(parsedTokens).parseExpr();
        String finalizedCode = MasmGenerator.generate(translatedCode);

        writeCodeToFile(finalizedCode);
        printCode(finalizedCode);
    }

    private static StringBuilder getExpression(String[] args) {
        StringBuilder expression = new StringBuilder();
        for (String arg: args) {
            expression.append(arg).append(" ");
        }
        return expression;
    }

    private static void printParsedTokens(List<Token> parsedTokens) {
        for (int index = 0; index < parsedTokens.size(); index++) {
            Token token = parsedTokens.get(index);
            System.out.printf("Token[%d]  =  %s (%s)\n", index, token.getValue(), token.userFriendlyType);
        }
        System.out.println();
    }

    private static void writeCodeToFile(String code) {
        try (PrintStream out = new PrintStream(new FileOutputStream("output.asm"))) {
            out.print(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printCode(String code) {
        System.out.println(code);
    }

}
