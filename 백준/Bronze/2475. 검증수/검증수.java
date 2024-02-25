import  java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int num = 0; 5 > num; num ++) {
            int temp = sc.nextInt();
            sum += Math.pow(temp, 2);
        }
        System.out.println(sum%10);
        sc.close();
    }
}