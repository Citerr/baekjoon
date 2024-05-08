import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] stair = new int[301];
  static int[] alone = new int[301];
  static int[] pair = new int[301];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++)
      stair[i + 1] = Integer.parseInt(br.readLine());
    br.close();

    alone[1] = stair[1];
    alone[2] = stair[2];
    pair[1] = stair[1];
    pair[2] = stair[1] + stair[2];

    int res = upStair(N);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(res  + "");
    bw.flush();
    bw.close(); 
  }

  static int upStair(int N) {
    if (pair[N] == 0) {
      int case1 = stair[N] + aloneStair(N - 1);
      int case2 = stair[N] + upStair(N - 2);
      pair[N] = Math.max(case1, case2);
    }
    return pair[N];
  }

  static int aloneStair(int N) { // 7 (6) 5 이런 식으로 76 같은 느낌이 아니라 7만 남을 때.
    if (alone[N] == 0) 
      alone[N] = stair[N] + upStair(N - 2);
    return alone[N];
  }
}