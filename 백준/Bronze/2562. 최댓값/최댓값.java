import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int index = 0;
        
        for (int i = 0; 9 > i; i++) {
            int num = sc.nextInt();
            if (max < num) index = i + 1;
            max = Math.max(max, num); 
        }
        
        System.out.println(max);
        System.out.println(index);
        sc.close();
    }
}