package IntroductionToIt;

import javax.swing.*;

public class isSorted {

    public static boolean isSorted(int[] array, SortOrder order) {
    boolean isTrue=false;
        try {



        if (order == SortOrder.ASC) {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    isTrue = false;
                    return isTrue;
                }
            }
            isTrue = true;
            return isTrue;
        } else if (order == SortOrder.DESC) {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] < array[i+1]) {
                    isTrue = false;
                    return isTrue;
                }
            }
            isTrue = true;
            return isTrue;
        }


        return isTrue;

    } catch (IllegalArgumentException e) {
        e.getMessage();
    }

        return isTrue;

}




}
