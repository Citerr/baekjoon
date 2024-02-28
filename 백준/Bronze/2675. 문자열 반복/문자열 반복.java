import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; num > i; i++) {
		    int word = sc.nextInt();
		    String s = sc.next();
		    
		    for (int row = 0; s.length() > row; row++) {
		        for (int col = 0; word > col; col++) {
		            System.out.print(s.charAt(row));
		        }
		    }
		    System.out.println();
		}
		sc.close();
	}
}