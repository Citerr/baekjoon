import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      for (int i = 0; 26 > i; i++) System.out.print(str.indexOf(i + 'a') + " ");
      sc.close();
   }
}