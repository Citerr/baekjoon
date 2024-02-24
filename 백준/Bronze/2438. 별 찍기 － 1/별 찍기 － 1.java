import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 0; num > i; i++) {
            for(int j = 0; i + 1 > j; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}