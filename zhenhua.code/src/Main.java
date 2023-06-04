import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] A={1, 4, 2, -2, 5};
        int[] B={7, -2, -2, 2, 5};

        //System.out.println(solution(s1));
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if(A.length!=B.length){
            return 0;
        }
        int sum =Arrays.stream(A).sum();
        if(sum%2 !=0 ){
            return 0;
        }
        if(sum!= Arrays.stream(B).sum()){
            return 0;
        }
        int sum_a=0;
        int sum_b=0;
        for(int i=0; i<A.length-1;i++){
            sum_a+=A[i];
            sum_b+=B[i];
            if((sum_a==sum_b) && (sum_a==sum/2)){
                return i;
            }
        }

        return 0;
    }
}