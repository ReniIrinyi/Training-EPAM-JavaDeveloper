import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InitGame {
    private GameBoard game;
    private int trefferCounter = 0;
    private  int MAXTREFFER = 9;
    private int LIFE=9;
    public InitGame(int nrOfStartups){
        game=new GameBoard(nrOfStartups);
        System.out.println("Versuche die X,Y-Koordinaten der Startups zu erraten... ");
        System.out.println();
        game.getSchiff();
        init();
    }

    public void init() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Eingabe starten: ");

        while (trefferCounter <= MAXTREFFER && !this.isAllShiffKilled() || LIFE>0) {
            String input = scan.next();

            if (input.equals("0")) {
                break;
            }

            if(input.equals("9")){
            game.getCheatSheat();
            }

            if(LIFE==0){
                break;
            }

            if(isAllShiffKilled()){
                break;
            }

            else {
                boolean hit=false;
                for(Startup startup:game.getStartups()) {
                    if (startup.isEqualToLabel(input)) {
                        trefferCounter++;
                        hit = true;
                        break;
                    }
                }
                if(!hit) {
                    System.out.println("probiere nochmal");
                    LIFE--;
                }

            }
        }

    }
    private boolean isAllShiffKilled(){
        boolean isKilled=false;
        if(game.getStartups().get(0).isKilled() && game.getStartups().get(1).isKilled() && game.getStartups().get(2).isKilled()){
            String string = LIFE != 0 ? "Du hast gewonnen. Deine Leben: " +LIFE : "Du hast verloren. Deine Leben: " +LIFE;
            System.out.println("Du hast " + trefferCounter + " treffer gehabt. " + string);
            isKilled=true;
        } else {
            System.out.println("Du hast noch "+LIFE+" Leben, und insgesamt "+trefferCounter+ " treffer");
            System.out.println();
        }
        return isKilled;
        }

}
