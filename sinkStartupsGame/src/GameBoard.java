import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {
    private int y[]={0,1,2,3,4,5,6};
    private String x[]={"A", "B","C", "D", "E", "F", "G" };

    public GameBoard() {
        System.out.println("SINK THE STARTUPS");
        System.out.println();
        this.getGameBoard();
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

    @Override
    public String toString() {
        return "GameBoard{" +
                "y=" + Arrays.toString(y) +
                ", x=" + Arrays.toString(x) +
                '}';
    }
}
