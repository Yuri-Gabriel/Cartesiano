package main.exprInterpreter.token;

public enum LogarithmType {
    LOG("log"),
    LN("ln");

    private String value;

    LogarithmType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
