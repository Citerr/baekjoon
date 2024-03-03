import java.util.Scanner;
import java.util.HashSet;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> remains = new HashSet<>();
		int res = 0;
		
		for(int i = 0; i < 10; i++) {
		    int temp = sc.nextInt();
		    remains.add(temp%42);
		}
		
		for (int remain : remains) res++;
		System.out.println(res);
	}
}