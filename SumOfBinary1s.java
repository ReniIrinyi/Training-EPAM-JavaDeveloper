package IntroductionToIt;

public class SumOfBinary1s {
    public static int sumOfBinary(int n) {

        String binary=Integer.toBinaryString(n);
        int counter=0;
        String [] strings=binary.split("");

        for(String bin:strings){
            if(bin.equals("1")){
                counter++;
            }
        }


        System.out.println(counter);
        return counter;
    }

}
