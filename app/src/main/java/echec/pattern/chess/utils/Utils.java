package echec.pattern.chess.utils;

public class Utils {
    static public void resetTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
