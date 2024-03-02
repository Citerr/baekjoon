import java.util.Scanner;
import java.util.Arrays;

//ascending, descending, mixed
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for(int i = 0; 8 > i; i++) arr[i] = sc.nextInt();
        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] des = {8, 7, 6, 5, 4, 3, 2, 1};

        if (Arrays.equals(arr, asc)) System.out.println("ascending");
        else if (Arrays.equals(arr, des)) System.out.println("descending");
        else System.out.println("mixed");
        
        sc.close();
    }
} 