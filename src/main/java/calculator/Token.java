package calculator;

// On a 2 types token : number ou opérateur

public class Token {
    public static final int NUMERO = 1;
    public static final int OPERATEUR = 2;

    private final int type;
    private final String value;

    //Constructor
    public Token(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
