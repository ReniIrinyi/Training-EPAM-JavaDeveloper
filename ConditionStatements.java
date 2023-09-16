package IntroductionToIt;

public class ConditionStatements {

    public static int task1(int n) {
        int output=0;
        if( n<0){
            output=Math.abs(n);
        }
        if(n>0){
            output=n*n;
        }
        return output;
    }

}
