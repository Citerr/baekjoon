import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Mem[] mem = new Mem[N];
		int[] ag = new int[N];
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    ag[i] = Integer.parseInt(st.nextToken());
		    mem[i] = new Mem(ag[i], st.nextToken());
		}
		Arrays.sort(ag);
		br.close();
		
		Label: for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (i != 0 && ag[i - 1] == ag[i]) continue Label;
		        if (ag[i] == mem[j].age) bw.write(mem[j].age + " " + mem[j].name + "\n");
		    }
		}
		
		bw.flush();
		bw.close();
	}
}

class Mem{
    int age;
    String name;
    Mem(int age, String name) {
        this.age = age;
        this.name = name;
    }
}