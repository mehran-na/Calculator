package calculator;

import java.util.*;

public class Tokenizer {
    private final String expression;

    //Constructor :
    public Tokenizer(String expression) {
        if (!InputValidator.isValidInput(expression)) {
            throw new IllegalArgumentException("Invalid input expression");
        }
        this.expression = expression;
    }

    //Method pour transferer String au List :
    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        // Verifier chaque character
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // si character est numéro :
            if (Character.isDigit(c) || c == '.') {
                numberBuilder.append(c); // ajoute à numberBuilder (grand numéro)
            } else {
                if (!numberBuilder.isEmpty()) {
                    tokens.add(new Token(Token.NUMERO, numberBuilder.toString()));
                    numberBuilder.setLength(0); // reset numberBuilder
                }

                // Si character est un opérateur ou non
                try {
                    Operator op = Operator.fromChar(c);
                    tokens.add(new Token(Token.OPERATEUR, String.valueOf(op.getSymbole())));
                } catch (IllegalArgumentException e) {
                    if (!Character.isWhitespace(c)) {
                        throw new IllegalArgumentException("Caractère invalide dans l'expression: " + c);
                    }
                    // si character est space - rien faire
                }
            }
        }

        // si il y a numero a la fin :
        if (!numberBuilder.isEmpty()) {
            tokens.add(new Token(Token.NUMERO, numberBuilder.toString()));
        }

        return tokens;
    }
}
