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
}
