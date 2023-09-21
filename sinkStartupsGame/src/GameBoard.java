import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {
    private final ArrayList<Startup> startups=new ArrayList<>();

    private int y[]={0,1,2,3,4,5,6};
    private String x[]={"A", "B","C", "D", "E", "F", "G" };

    public GameBoard(int nrOfStartups) {
        for(int i=0; i<nrOfStartups; i++){
            Startup startup =new Startup("STARTUP_"+i);
            startups.add(startup);
        }
        System.out.println("SINK THE STARTUPS");
        System.out.println();
        this.generateRandomFields(nrOfStartups);
        this.getGameBoard();
        System.out.println();
        this.getCheatSheat();
    }

    public int getY(int index){
        return y[index];
    }

    public String getX(int index){
        return x[index];
    }

    public void getGameBoard(){
        for(int i=0; i<y.length; i++ ){
            System.out.print(x[i]);
            for(int j=0; j<x.length; j++){
                System.out.print("[]");
            }
            System.out.println();
        }
        for(int nr:y){
            System.out.print(" "+nr+"");
        }
        System.out.println(" ");
    }
    public void generateRandomFields(int nrOfStartups){
        for (int i = 0; i < nrOfStartups; i++) {
            int randomNr=(int) (Math.random()*2);
            if(randomNr==1){
                startups.get(i).generateRandomFieldsHorizontal(this);
            } else {
                startups.get(i).generateRandomFieldsVertical(this);
            }
        }
    }

    public ArrayList<Startup> getStartups() {
        return startups;
    }
    public void getSchiff(){
        System.out.println("Die Startups to sink are: ");

        for(Startup startup:startups){
            startup.getSchiff();
        }
        System.out.println();
    }
    public void getCheatSheat(){
        System.out.println("Here the CheatSheat");
        for(Startup star:startups){
            star.getCheatSheat();
        }
    }
    @Override
    public String toString() {
        return "GameBoard{" +
                "y=" + Arrays.toString(y) +
                ", x=" + Arrays.toString(x) +
                '}';
    }
}
