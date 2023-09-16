package IntroductionToIt;

public class FindMaximum {
    public static int task2(int n) {
        int first=n%10;
        int second=n%100/10;
        int third=n%1000/100;

        int max1=third;
        int max2=second;
        int max3=first;

        if(first>second && first >third){
            max1=first;
            max3=third;

            if(third > second ){
                max2=third;
                max3=second;
            }

        } else if(second > first && second > third){
            max1=second;
            max2=third;


            if(first > third ){
                max2=first;
                max3=third;
            }
        }
        int max=(((max1*10)+max2)*10)+max3;

        System.out.println(max);
        return max;
    }

}
