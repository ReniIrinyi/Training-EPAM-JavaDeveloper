import java.util.Arrays;

public class Startup {
    private String name;
    private int y[]=new int[3];
    private String x[]=new String[3];
    private String[] label=new String[3];
    private int trefferCounter=0;
    private boolean killed=false;

    public void increaseTrefferCounter() {
        if(trefferCounter<3){
            this.trefferCounter = trefferCounter+1;
            System.out.println("Du hast diese Startup getroffen: " + this.name);
        }
        else {
            System.out.println(this.name+" => Startup is tot");
            this.killStartup();
        }
    }

    private void setY(int x,int y, int z) {
        this.y[0] = x;
        this.y[1] = y;
        this.y[2] = z;
    }
    public void setName(String name) {
        this.name = name;
    }

    private void setX(String x, String y, String z) {
        this.x[0]=x;
        this.x[1]=y;
        this.x[2]=z;
    }

    public boolean isEqualToLabel(String string){
        boolean equalString=false;
        for(int i=0; i<label.length; i++){
            if(string.equals(label[i])){
                equalString= true;
            }
        }
        return equalString;
    }
    public boolean isKilled() {
        return killed;
    }

    public void getSchiff(){
        System.out.println(this.name+": ");
        System.out.println("_[]");
        System.out.print("[][]");

        for(int i=0; i<x.length; i++){
            System.out.print("_");
        }
        System.out.print("|Z/");
        System.out.println();
            System.out.print("\\");
            for(int j=0; j<x.length; j++){
                System.out.print("__");
            }
            System.out.print("/");
            System.out.println();
    }

    public void getCheatSheat(){
        System.out.println(this.name);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println("__________________");
    }
    public void generateRandomFieldsVertical(GameBoard gameBoard){
        int randomIndex=(int) (( Math.random()* 2));
        int randomNr=(int) (Math.random()* 4);
        this.setX(gameBoard.getX(randomNr), gameBoard.getX(randomNr+1),gameBoard.getX(randomNr+2));
        this.setY(gameBoard.getY(randomNr), gameBoard.getY(randomNr),gameBoard.getY(randomNr));
        this.getLabelsStrings();
    }
    public void generateRandomFieldsHorizontal(GameBoard gameBoard){
        int randomIndex=(int) ( Math.random()* 2);
        int randomNr=(int) (Math.random()* 5);
        this.setX(gameBoard.getX(randomNr), gameBoard.getX(randomNr),gameBoard.getX(randomNr));
        this.setY(gameBoard.getY(randomNr), gameBoard.getY(randomNr+1),gameBoard.getY(randomNr+2));
        this.getLabelsStrings();
    }
    private void getLabelsStrings() {
        String[] labelsString=new String[x.length];
        for (int i = 0; i < this.y.length; i++) {
            String string=x[i]+y[i];
            labelsString[i]=string;
        }
       this.label=labelsString;
    }
    private void killStartup(){
      this.killed=true;
    }

}
