class PartA{
    public static void main(String[] args) {
        
        int[] A = {1,2,3,4,5,6};
        int[] B = {1,2,3,4,5,6};

        // Total combinations possibe = no. of faces in die A * no. of faces in die B
        
        int totalCombinaions = A.length * B.length;
        System.out.println("Total combinations possibe = " + totalCombinaions);
        System.out.println();

        // All possible combinations include 
        System.out.println("All possible combinations include :");
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }

        
        System.out.println();
        int[][] sum = new int[6][6];   // sum array stores the sum of all the face values in each outcome 
        int count=0;

        
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                sum[i][j] = A[i]+B[j];   
            }
         
        }
        //Probability of all Possible Sums occurring among the number of combinations from (2)

        System.out.println("Probability of all Possible Sums occurring among the number of combinations from (2).");

        for(int k=2;k<=12;k++){

            for(int i=0;i<A.length;i++){
                for(int j=0;j<B.length;j++){
                    if(sum[i][j]==k)
                    count+=1;

                }
            }
            
            System.out.println("P(sum="+k+")="+count+"/36");
            count =0;
        }
    }
}