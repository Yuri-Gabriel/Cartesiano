package main.exprInterpreter.token;

public enum TrigType {
    SIN("sin"),
    COS("cos"),
    TAN("tan");

    private String value;

    TrigType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
