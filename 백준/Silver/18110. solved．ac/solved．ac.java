import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    int sum = 0;
    int except = Math.round((float)N/100 *15);
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    br.close();

    for (int i = except; i < N - except; i++) {
      sum += arr[i];
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(Math.round((float)sum/(N-2*except)) + "\n");
    bw.flush();
    bw.close();
  }
}