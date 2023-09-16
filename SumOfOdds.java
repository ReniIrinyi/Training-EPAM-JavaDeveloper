package IntroductionToIt;

public class SumOfOdds {
    public static int sumOddDigits(int n) {

        int first=n%10000/1000;
        int second=n%1000/100;
        int third=n%100/10;
        int fourth=n%10;
        int sum=0;

        if(first %2 !=0){
            sum+=first;
        }
        if(second %2 !=0){
            sum+=second;
        }
        if(third %2 !=0){
            sum+=third;
        }
        if(fourth %2 !=0){
            sum+=fourth;
        }
        return sum;
    }

}
