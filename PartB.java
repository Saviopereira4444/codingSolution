import java.util.*;

public class PartB {
    public static void main(String[] args) {

        int[] Die_A = {1, 2, 3, 4, 5, 6};
        int[] Die_B = {1, 2, 3, 4, 5, 6};
        int[] New_Die_A = new int[6];
        int[] New_Die_B = new int[6];
        
        System.out.println("Die_A: " + Arrays.toString(Die_A));
        System.out.println("Die_B: " + Arrays.toString(Die_B));

        undoom_dice(Die_A, Die_B, New_Die_A, New_Die_B);

        System.out.println("New_Die_A: " + Arrays.toString(New_Die_A));
        System.out.println("New_Die_B: " + Arrays.toString(New_Die_B));
        
    }

    public static void undoom_dice(int[] Die_A, int[] Die_B, int[] New_Die_A, int[] New_Die_B) {

        for (int i=0;i<6;i++) {
            if (Die_A[i] > 4) {
                New_Die_A[i] = Die_A[i] - 3;  
                
            }
            else{
                New_Die_A[i] = Die_A[i];
            }
        }
        
        for(int i=0;i<6;i++){
            if(Die_B[i] == 2){
                New_Die_B[i] = Die_B[i] + 6;

            }
            else{                
                New_Die_B[i] = Die_B[i];
            }   
        }
            
    }
}


