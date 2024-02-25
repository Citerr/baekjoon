import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int row = 1; num >= row; row++) {
            for(int blank = row; num > blank; blank++) {
                System.out.print(" ");
            }
            for(int star = 0; row > star; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}