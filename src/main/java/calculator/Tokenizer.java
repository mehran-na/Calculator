package calculator;

import java.util.*;

public class Tokenizer {
    private final String expression;

    // Constructeur : Initialisation de l'expression
    public Tokenizer(String expression) {
        // Vérification de la validité de l'expression d'entrée avant de la traiter
        if (!InputValidator.isValidInput(expression)) {
            throw new IllegalArgumentException("Expression d'entrée invalide");
        }
        this.expression = expression;
    }

    // Méthode pour transformer une chaîne en une liste de tokens :
    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder(); // pour numéro

        // Vérification chaque caractère dans l'expression :
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Si le caractère est un chiffre ou un point décimal (pour les numéros flottants) :
            if (Character.isDigit(c) || c == '.') {
                numberBuilder.append(c);
            } else if (c == '+' || c == '-') {
                if (i == 0 || isPreviousCharOperator(expression, i)) {
                    // Si au début ou après un autre opérateur => signe d’un nombre
                    numberBuilder.append(c);
                } else {
                    if (!numberBuilder.isEmpty()) {
                        tokens.add(new Token(Token.NUMERO, numberBuilder.toString()));
                        numberBuilder.setLength(0);
                    }
                    tokens.add(new Token(Token.OPERATEUR, String.valueOf(c)));
                }
            } else {
                if (!numberBuilder.isEmpty()) {
                    tokens.add(new Token(Token.NUMERO, numberBuilder.toString()));
                    numberBuilder.setLength(0); // Réinitialisation de numberBuilder pour le prochain nombre
                }
                // Si le caractère est un autre opérateur (par exemple *, /)
                try {
                    Operator op = Operator.fromChar(c);
                    tokens.add(new Token(Token.OPERATEUR, String.valueOf(op.getSymbole())));
                } catch (IllegalArgumentException e) {
                    // Si c'est un caractère invalide (et non un espace), on lance une exception
                    if (!Character.isWhitespace(c)) {
                        throw new IllegalArgumentException("Caractère invalide: " + c);
                    }
                    // Si c'est un espace, on ne fait rien
                }
            }
        }
        // Si un nombre reste dans numberBuilder à la fin de l'expression, on l'ajoute également
        if (!numberBuilder.isEmpty()) {
            tokens.add(new Token(Token.NUMERO, numberBuilder.toString()));
        }

        return tokens;
    }

    private boolean isPreviousCharOperator(String expr, int index) {
        for (int i = index - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if (Character.isWhitespace(ch)) continue;
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }
        return true;
    }
}
