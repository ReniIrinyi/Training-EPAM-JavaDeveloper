package IntroductionToIt;

public class SumOfFibonacis {
    public static int sumOfFibonacciNumbers(int n) {
        if (n <= 0)
            return 0;

        int fibo[]=new int[n+1];
        fibo[0] = 0; fibo[1] = 1;

        int sum = fibo[0] + fibo[1];

        for (int i=2; i<n; i++)
        {

            fibo[i] = fibo[i-1]+fibo[i-2];
            sum += fibo[i];




        }
        System.out.println(fibo.length);
        System.out.println(sum);
        return sum;

    }

}
