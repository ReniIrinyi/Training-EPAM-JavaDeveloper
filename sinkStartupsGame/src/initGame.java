import java.util.ArrayList;
import java.util.Scanner;

public class initGame {
    private GameBoard game;
    private final ArrayList<Startup> startups = new ArrayList<>();
    private int trefferCounter = 0;
    private int MAXTREFFER = 9;
    private int LIFE = 9;

    public initGame(int nrOfStartups) {
        game = new GameBoard();
        for (int i = 0; i < nrOfStartups; i++) {
            Startup startup = new Startup("STARTUP_" + i, game);
            startups.add(startup);
            startup.getSchiff();
            startup.getCheatSheat();
        }
        System.out.println("Versuche die X,Y-Koordinaten der Startups zu erraten... ");
        System.out.println();

        setupGame();
    }

    public void setupGame() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Eingabe starten: ");

        while (trefferCounter <= MAXTREFFER && !this.isGameFinished() || LIFE > 0) {
            String input = scan.next();

            if (input.equals("0")) {
                break;
            }

            if (LIFE == 0) {
                break;
            }

            if (isGameFinished()) {
                break;
            } else {
                boolean hit = false;
                for (Startup startup : startups) {
                    if (startup.isEqualToLabel(input)) {
                        trefferCounter++;
                        hit = true;
                        break;
                    }
                }
                if (!hit) {
                    System.out.println("probiere nochmal");
                    LIFE--;
                }

            }
        }

    }

    private boolean isGameFinished() {
        boolean isKilled=false;

        if(startups.get(0).isKilled() && startups.get(1).isKilled() && startups.get(2).isKilled()){
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
