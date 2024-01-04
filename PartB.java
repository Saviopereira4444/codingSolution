import java.util.Arrays;

public class PartB {
    
    public static void main(String[] args) {     

        int[] Die_A = {1, 2, 3, 4, 5, 6};
        int[] Die_B = {1, 2, 3, 4, 5, 6};
        int[] original_dieA = {1,2,3,4,5,6};
        int[] original_dieB = {1,2,3,4,5,6};
        
        System.out.println("Die_A: " + Arrays.toString(Die_A));
        System.out.println("Die_B: " + Arrays.toString(Die_B));

        int n = Die_A.length-1;
        int m = Die_A.length-2;
        int doomed_sum = 21;
        
        int max_A = 4;
        int min_A = 1;
        // 
        for(int i=0;i<=4;i++){
            for(int j=0;j<=4;j++){
                    Die_A[m] = i;
                    Die_A[n] = j;

                    int sum = Arrays.stream(Die_A).sum();
                    int difference = Math.abs(sum - doomed_sum) ;

                    // add this difference iteratively to all elements in B
                    for(int k=0;k<6;k++){
                        int temp = Die_B[k];
                        Die_B[k] = Die_B[k]+difference;
                        
                        // check max sum = 12 , min sum =2;
                        int max_B = Arrays.stream(Die_B).max().orElseThrow(null);
                        int min_B = Arrays.stream(Die_B).min().orElseThrow(null);
                        
                        if(max_A+max_B == 12 && min_A+min_B==2)
                        {             
                            double[] probabilities = calculateSumProbabilities(Die_A, Die_B);
                            double[] newprobabilities = calculateSumProbabilities(original_dieA, original_dieB);
                       
                                if (areArraysEqual(probabilities, newprobabilities)) {
                                    undoom(Die_A, Die_B);                                                          
                                    return;
                                }  
                        }
                        Die_B[k]= temp;
                    }
            }
        }
   }


   // function to calculate sum probabilaties of current die and original die
    private static double[] calculateSumProbabilities(int[] dieA, int[] dieB) {
        int numSides = dieA.length;
        double[] probabilities = new double[11]; // 11 possible sums (2 to 12)

        for (int i = 0; i < numSides; i++) {
            for (int j = 0; j < numSides; j++) {
                int sum = dieA[i] + dieB[j];
                probabilities[sum - 2] += 1.0 / (numSides * numSides);
            }
        }

        return probabilities;
    }

    // function to check if the sum probabilaties are equal
    private static boolean areArraysEqual(double[] array1, double[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    // function to print the undoomed die satisfying all constrains
    private static void undoom(int[] arrayA, int[] arrayB) {
        
        System.out.println("Undoomed Die Values:");
        System.out.println("New_Die A: " + Arrays.toString(arrayA));
        System.out.println("New_Die B: " + Arrays.toString(arrayB));
        System.exit(0);
    }

}
