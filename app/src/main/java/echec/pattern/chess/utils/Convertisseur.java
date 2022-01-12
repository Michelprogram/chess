package echec.pattern.chess.utils;

public class Convertisseur {
    public static String numberPositionToLetterPosition(int[] position){
        //97 -> a dans la table ASCII
        final int asciiChar = 97 + position[1];
        String tab = Integer.toString(8 - position[0]) + String.valueOf( ((char) asciiChar));
        return tab;
    }

    public static String toLetter(int n){
        final int asciiChar = 97 + n;
        return String.valueOf( ((char) asciiChar));
    }
}
