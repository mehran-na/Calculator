package calculator;

import java.util.List;
import java.util.Scanner;
public class App {
    public double calculate(String input) {
        Tokenizer tokenizer = new Tokenizer(input);
        List<Token> tokens = tokenizer.tokenize();

        Evaluator evaluator = new Evaluator();
        return evaluator.evaluate(tokens);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App calculator = new App();

        System.out.println("Entrez une expression mathématique (par exemple 3 + 4 * 2) :");
        String input = scanner.nextLine();

        try {
            double result = calculator.calculate(input);
            System.out.println("Résultat : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}