package calculator;

public enum Operator {
    ADDITION('+'),
    SOUSTRACTION('-'),
    DIVISION('/'),
    MULTIPLICATION('*');

    private final char symbole;

    Operator(char symbole) {
        this.symbole = symbole;
    }

    public char getSymbole() {
        return symbole;
    }

    //Retourne l'opérateur correspondant au caractère donné.
    public static Operator fromChar(char c) {
        for (Operator op : values()) {
            if (op.symbole == c) return op;
        }
        throw new IllegalArgumentException("Opérateur inconnu: " + c);
    }
}
