package com.compiler;

public class MasmGenerator {
    private static String removeWhitespaces(String code) {
        return code.replaceAll("[\\n]{3,}", "\n\n").trim();
    }

    public static String generate(String code) {
        code = removeWhitespaces(code);

        code = "INCLUDE Irvine32.inc\n" +
                "\n" +
                ".code\n" +
                "main PROC\n" +
                "\n" +
                code + "\n" +
                "\n" +
                "MOV EAX, 0\n" +
                "POP AX\n" +
                "call WriteDec\n" +
                "\n" +
                "exit\n" +
                "main ENDP\n" +
                "END main";

        return code;
    }
}
