package IntroductionToIt;

public class MultiplicationArithmeticElements {

    public static int multiArithmeticElements(int a1, int t, int n) {

        int mult=1;
        for (int i = 0; i < n; i++)
        {
            int a=a1+t*i;
            mult =a*mult;
        }
        System.out.println(mult);
        return mult;

    }

}
