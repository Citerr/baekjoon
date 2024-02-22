import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toUpperCase();
        int[] alpha = new int[26];
        int max = 0, flag= 0, index = 0;        

        for(int i = 0; str.length() > i; i++) {
            int temp = str.charAt(i) - 'A';
            alpha[temp]++;
        }

        for(int i = 0; 26 > i; i++) {
            if (max == alpha[i]) {
                flag = 1;
            }

            if (max < alpha[i]) {
                max =  alpha[i];
                index = i;
                flag = 0;
            }
        }

        if (flag == 0) {
            index += 'A';
            System.out.println((char)index);
        }
        else
            System.out.println("?");
    }
}