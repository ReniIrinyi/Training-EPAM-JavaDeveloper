package IntroductionToIt;

public class maximumDistance {
    public static int maximumDistance(int[] array) {
        int max = 0;
        int maxfirst=0;
        int maxsec=0;
        try {

            if (array.length >= 0 && array != null) {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > max) {

                        max = array[i];

                    }
                }
                for(int i = 0; i < array.length - 1; i++){
                    if(array[i]==max){
                        maxfirst=i;
                        break;
                    }


                }
                for(int i = array.length - 1; i >0 ; i--) {
                    if (array[i] == max) {
                        maxsec = i;
                        break;
                    }
                }
            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return maxsec-maxfirst;
    }
}
