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
    int[] arr = new int[N];
    int sum = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }
    br.close();
    Arrays.sort(arr);

    int[][] freq = new int[N][2];
    int idx = 0;
    for (int i = 0; i < N; i++) {
      if (i != idx && arr[idx] == arr[i] ) {
        freq[idx][1]++;
      }
      else {
        idx = i;
        freq[idx][0] = arr[idx];
        freq[idx][1]++;
      }
    }
    Arrays.sort(freq, (e1, e2) -> {
      if (e1[1] == e2[1]) return e1[0] - e2[0];
      else return e2[1] - e1[1];
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(Math.round((double)sum/N) + "\n"); // 평균
    bw.write(arr[N/2] + "\n"); //중앙값
    //최빈값
    if (N == 1) bw.write(freq[0][0] + "\n");
    else if (freq[0][1] == freq[1][1]) bw.write(freq[1][0] + "\n");
    else bw.write(freq[0][0] + "\n");
    bw.write(arr[N - 1] - arr[0] + "\n");
    bw.flush();
    bw.close();
  }
}