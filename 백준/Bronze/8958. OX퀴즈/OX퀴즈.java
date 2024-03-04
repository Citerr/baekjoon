import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		sc.nextLine();
	    for (int i = 0; i < tCase; i++) {
	        int sum = 0;
	        int score = 0;
	        String aCase = sc.nextLine();
	        
	        for (int j = 0; j < aCase.length(); j++){
	            if (aCase.charAt(j) == 'X') score = 0;
	            if (aCase.charAt(j) == 'O') score += 1;
	            sum += score;
	        }
	        
	        System.out.println(sum);
	    }
	    sc.close();
	}
}