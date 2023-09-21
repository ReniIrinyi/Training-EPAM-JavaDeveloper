import java.util.ArrayList;
import java.util.Arrays;

public class Startup {
    private String name;
    private ArrayList<Integer>y=new ArrayList<>();
    private ArrayList<String> x=new ArrayList<>();
    private ArrayList<String> label=new ArrayList<>();
    private int trefferCounter;
    private boolean killed=false;

    public Startup(String name, GameBoard gameBoard) {
        this.trefferCounter=1;
        this.name = name;
        int random=(int) (Math.random()* 5);
        this.generateRandomFields(gameBoard, random);
    }
    public void generateRandomFields( GameBoard gameBoard, int random){
            int randomNr=(int) (Math.random()*2);
            if(randomNr==1){
                this.generateRandomFieldsHorizontal(gameBoard, random);
            } else {
                this.generateRandomFieldsVertical(gameBoard, random);
            }

    }

    private void increaseTrefferCounter() {
        if(label.isEmpty()) {
            this.killStartup();
        }
        if(trefferCounter<=3){
            this.trefferCounter++;
            if(!this.isKilled()){
                System.out.println("Du hast diese Startup getroffen: " + this.name);
            }
        }
        else {
            this.killStartup();
        }
    }
    private void setY(int x,int y, int z) {
      this.y.add(0,x);
      this.y.add(1,y);
      this.y.add(2,z);
    }
    private void setX(String x, String y, String z) {
        this.x.add(0,x);
        this.x.add(1,y);
        this.x.add(2,z);
    }

    public boolean isEqualToLabel(String string){
        boolean isEqual=false;
        int index=label.indexOf(string);
        if(index>=0){
            label.remove(string);
            this.increaseTrefferCounter();
            isEqual=true;
        } else{
            return isEqual;
        }
        return isEqual;

    }
    public boolean isKilled() {
        return killed;
    }

    public void getSchiff(){
        System.out.println(this.name+": ");
        System.out.println("_[]");
        System.out.print("[][]");

        for(int i=0; i<x.size(); i++){
            System.out.print("_");
        }
        System.out.print("|Z/");
        System.out.println();
            System.out.print("\\");
            for(int j=0; j<x.size(); j++){
                System.out.print("__");
            }
            System.out.print("/");
            System.out.println();
    }

    public void getCheatSheat(){
        System.out.println(this.name);
        System.out.println(Arrays.toString(x.toArray()));
        System.out.println(Arrays.toString(y.toArray()));
        System.out.println("__________________");
    }
    public void generateRandomFieldsVertical(GameBoard gameBoard, int randomNr){
        this.setX(gameBoard.getX(randomNr), gameBoard.getX(randomNr+1),gameBoard.getX(randomNr+2));
        this.setY(gameBoard.getY(randomNr), gameBoard.getY(randomNr),gameBoard.getY(randomNr));
        this.getLabelsStrings();
    }
    public void generateRandomFieldsHorizontal(GameBoard gameBoard,int randomNr){
        this.setX(gameBoard.getX(randomNr), gameBoard.getX(randomNr),gameBoard.getX(randomNr));
        this.setY(gameBoard.getY(randomNr), gameBoard.getY(randomNr+1),gameBoard.getY(randomNr+2));
        this.getLabelsStrings();
    }

    private void getLabelsStrings() {
        ArrayList<String> labelsString=new ArrayList<>();
        for (int i = 0; i < this.y.size(); i++) {
            String string= x.get(i) + y.get(i);
            labelsString.add(string);
        }
       this.label=labelsString;
    }
    private void killStartup(){
        System.out.println(this.name+" => Startup is tot");
        this.killed=true;
    }

}
