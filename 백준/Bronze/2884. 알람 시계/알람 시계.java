import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int oriH = sc.nextInt();
		int oriM = sc.nextInt();
		//24 * 60 = 1440 // 23:59 = 1439
		int alarm = oriH*60 + oriM - 45;
		if (alarm < 0) alarm = 1440 + alarm;
		
        System.out.println(alarm/60 + " " + alarm%60);
	}
}