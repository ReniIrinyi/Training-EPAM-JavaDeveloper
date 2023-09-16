package IntroductionToIt;

public class SwapEvensFromArray {
    public static void swapEven(int[] array) {
        try{
            if (array.length > 0 && array != null) {
                int[] currArray=array;
                for (int j = 1; j <= currArray.length; j += 1) {
                    for (int i = j - 1; i < currArray.length - j; i += 1) {
                        if (array[i] % 2 == 0 && array[currArray.length - j] % 2 == 0) {
                            int curr = array[i];
                            array[i] = currArray[currArray.length - j];
                            array[currArray.length - j] = curr;
                        }
                        break;
                    }
                }
            }
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
