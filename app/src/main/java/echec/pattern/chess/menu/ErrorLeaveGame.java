package echec.pattern.chess.menu;

public class ErrorLeaveGame extends Exception{
    public ErrorLeaveGame(String message){
        super(message);
    }
}
