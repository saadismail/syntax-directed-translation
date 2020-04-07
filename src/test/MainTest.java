import com.compiler.SyntaxDirectedTranslator;
import com.compiler.tokens.*;
import com.compiler.tokens.Number;
import com.compiler.Parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    public void processExpressionTest() {
        String expression = "22          *   (50 + (36 / 12)                   - 16)";

        List<Token> expectedTokens = Arrays.asList(
                new Number("22"),
                new Multiply(),
                new OpeningParanthesis(),
                new Number("50"),
                new Plus(),
                new OpeningParanthesis(),
                new Number("36"),
                new Divide(),
                new Number("12"),
                new ClosingParanthesis(),
                new Minus(),
                new Number("16"),
                new ClosingParanthesis()
        );

        List<Token> actualTokens = new Parser(expression).parseExpression();
        Assert.assertEquals(expectedTokens, actualTokens);

        new SyntaxDirectedTranslator(actualTokens).parseExpr();
    }
}