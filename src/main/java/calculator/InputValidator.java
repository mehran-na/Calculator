package calculator;

public class InputValidator {
    // Méthode pour vérifier si l'expression est valide
    public static boolean isValidInput(String input) {
        // Supprimer les espaces au début et à la fin de la chaîne
        input = input.trim();

        // Vérifier si la chaîne est vide
        if (input.isEmpty()) {
            return false;
        }

        // Vérifier que la chaîne contient uniquement des chiffres, des opérateurs ou des espaces
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Si le caractère est un chiffre ou un point décimal
            if (Character.isDigit(c) || c == '.') {
                continue;
            }

            // Si le caractère est un opérateur autorisé
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                continue;
            }

            // Si le caractère n'est pas un chiffre, un opérateur ou un espace valide
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }

        // Si tous les caractères sont valides
        return true;
    }

    // Méthode pour normaliser les opérateurs consécutifs (+ et -)
    public static String normalizeOperators(String expression) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-') {
                int sign = 1;
                // Traiter les + et - consécutifs
                while (i < expression.length() && (expression.charAt(i) == '+' || expression.charAt(i) == '-')) {
                    if (expression.charAt(i) == '-') {
                        sign *= -1;
                    }
                    i++;
                }
                result.append(sign == 1 ? '+' : '-');
            } else {
                result.append(c);
                i++;
            }
        }

        return result.toString();
    }

}
