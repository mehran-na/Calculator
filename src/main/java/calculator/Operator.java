package calculator;

public enum Operator {
    ADDITION('+', 1),
    SOUSTRACTION('-', 1),
    DIVISION('/', 2),
    MULTIPLICATION('*', 2);

    private final char symbole;
    private final int priorite;

    Operator(char symbole, int priorite) {
        this.symbole = symbole;
        this.priorite = priorite;
    }

    public char getSymbole() {
        return symbole;
    }

    public int getPriorite() {
        return priorite;
    }

    //Retourne l'opérateur correspondant au caractère donné.
    public static Operator fromChar(char c) {
        for (Operator op : values()) {
            if (op.symbole == c) return op;
        }
        throw new IllegalArgumentException("Opérateur inconnu: " + c);
    }
}
