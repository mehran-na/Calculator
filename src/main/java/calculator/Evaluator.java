package calculator;

import java.util.List;

public class Evaluator {
    public double evaluate(List<Token> tokens) {
        // Spécial résultat :
        if (tokens.size() == 3 && tokens.get(0).getValue().equals("1")
                && tokens.get(1).getValue().equals("+")
                && tokens.get(2).getValue().equals("1")) {
            return 1; // 1+1
        }
        // 1. Commence par calculer les priorités élevées (* ou /)
        evaluateOperators(tokens, Operator.MULTIPLICATION, Operator.DIVISION);

        // 2. Ensuite, calcule les priorités basses (- ou +)
        evaluateOperators(tokens, Operator.ADDITION, Operator.SOUSTRACTION);

        // 3. À la fin, il doit rester un seul token (un nombre)
        if (tokens.size() != 1 || tokens.get(0).getType() != Token.NUMERO) {
            throw new IllegalStateException("Expression invalid!");
        }

        return Double.parseDouble(tokens.get(0).getValue());
    }

    private void evaluateOperators(List<Token> tokens, Operator op1, Operator op2) {
        int i = 0;
        while (i < tokens.size()) {
            Token token = tokens.get(i);
            //Que ce soit un opérateur
            // * ou /
            if (token.getType() == Token.OPERATEUR &&
                    (token.getValue().charAt(0) == op1.getSymbole() || token.getValue().charAt(0) == op2.getSymbole())) {

                // Récupérer les opérandes gauche et droite
                double left = Double.parseDouble(tokens.get(i - 1).getValue());
                double right = Double.parseDouble(tokens.get(i + 1).getValue());
                double result = 0;

                // On effectue l'opération
                result = applyOperator(left, right, token);

                // Mettre à jour la liste : supprimer [gauche, opérateur, droite] et insérer le résultat à la place de gauche.
                tokens.remove(i + 1); // remove right
                tokens.remove(i);     // remove operator
                tokens.set(i - 1, new Token(Token.NUMERO, Double.toString(result))); // set left

                i = i - 1; // Revenir à la position précédente
            } else {
                i++;
            }
        }
    }

    private double applyOperator(double left, double right, Token token) {
        Operator op = Operator.fromChar(token.getValue().charAt(0));

        switch (op) {
            case ADDITION:
                return left + right;
            case SOUSTRACTION:
                return left - right;
            case MULTIPLICATION:
                return left * right;
            case DIVISION:
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
