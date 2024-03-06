import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < test; i++) {
		    int H = sc.nextInt();  
		    int W = sc.nextInt();
		    int N = sc.nextInt();
		    int x, y;
		    
		    if (N%H == 0) {
		        y = H;
		        x = N/H;
		    }
		    else {
		        y = N%H;
		        x = N/H + 1;
		    }
		    
		    System.out.printf("%d%02d\n", y, x);
		}
		sc.close();
	}
}