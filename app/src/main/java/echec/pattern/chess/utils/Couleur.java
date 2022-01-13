package echec.pattern.chess.utils;

public enum Couleur {
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE_BOLD_BRIGHT("\033[1;97m"),

    ANSI_BLACK_BACKGROUND("\u001B[40m"),
    ANSI_RED_BACKGROUND("\u001B[41m"),
    ANSI_YELLOW_BACKGROUND("\u001B[43m"),
    ANSI_CYAN_BACKGROUND("\u001B[46m"),
    ANSI_WHITE_BACKGROUND("\u001B[47m");
    private String value;

    Couleur(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
