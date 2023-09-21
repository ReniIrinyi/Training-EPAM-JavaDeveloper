import java.util.Arrays;

public class Game {
   private Startup[] startup;
    private final GameBoard gameBoard;

    public Game(int nrOfStartupsToSink) { //3
        this.gameBoard=new GameBoard();
        this.startup = new Startup[nrOfStartupsToSink];

        while (nrOfStartupsToSink > 0) {
            this.startup[nrOfStartupsToSink - 1] = new Startup();
            String[] randomNames = {"Startup01", "Startup02", "Startup03"};
            startup[nrOfStartupsToSink-1].setName(randomNames[nrOfStartupsToSink-1]);
            for (int i = 0; i < 3; i++) {
                int randomNr=(int) (Math.random()*2);
                if(randomNr==1){
                    this.startup[nrOfStartupsToSink-1].generateRandomFieldsHorizontal(gameBoard);
                } else {
                    this.startup[nrOfStartupsToSink-1].generateRandomFieldsVertical(gameBoard);
                }
            }
            nrOfStartupsToSink--;
        }
    }

    public Startup[] getStartups(){
        return this.startup;
    }

    public void getSchiff(){
        System.out.println("Die Startups to sink are: ");
        for(Startup startup:startup){
            startup.getSchiff();
        }
        System.out.println();
    }
}
