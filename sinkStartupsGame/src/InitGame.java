import java.util.Arrays;
import java.util.Scanner;

public class InitGame {

    Game game;
    private final Startup[] startup;
    int MAXTREFFER=9;

    public InitGame(int nrStartupsToSink){
        game=new Game(nrStartupsToSink);
        System.out.println("Versuche die X,Y-Koordinaten der Startups zu erraten... ");
        System.out.println();
        startup=game.getStartups();
        game.getSchiff();
        getCheatSheat();
        init();
    }

    public void init() {

        int trefferCounter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Eingabe starten: ");

        while (scan.hasNext()) {
            String input = scan.next();
            if (trefferCounter == MAXTREFFER || this.isAllShiffKilled()) {
                String string = trefferCounter < 10 ? "Du hast gewonnen" : "Du hast zu viele Treffer, hast verloren";
                System.out.println("Du hast " + trefferCounter + " treffer gehabt. " + string);
                break;
            }

            if (input.equals("0")) {
                break;
            }

            if(input.equals("9")){
            getCheatSheat();
            }

            while (trefferCounter <= MAXTREFFER || !this.isAllShiffKilled()) {
                if (startup[0].isEqualToLabel(input) && !startup[0].isKilled()) {
                    startup[0].increaseTrefferCounter();
                    trefferCounter++;
                    break;
                } else if (startup[1].isEqualToLabel(input) && !startup[1].isKilled()) {
                    startup[1].increaseTrefferCounter();
                    trefferCounter++;
                    break;
                } else if (startup[2].isEqualToLabel(input) && !startup[2].isKilled()) {
                    startup[2].increaseTrefferCounter();
                    trefferCounter++;
                    break;
                } else {
                    System.out.println("probiere nochmal");
                    System.out.print("Eingabe: ");
                    break;
                }

            }
        }
    }
    private boolean isAllShiffKilled(){
         return startup[0].isKilled() && startup[1].isKilled() && startup[2].isKilled();
        }

        private void getCheatSheat(){
            System.out.println("Here the CheatSheat");
            for(Startup star:startup){
                star.getCheatSheat();
            }
        }
}
