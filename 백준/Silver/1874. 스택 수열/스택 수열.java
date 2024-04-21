import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int elem = 0;
    Stack<Integer> stack = new Stack<>();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(br.readLine());

    Label: for (int i = 0; i < N; i++) {
      while (true) {
        if (elem < arr[i]) {
          stack.push(++elem);
          sb.append("+\n");
        } else if (stack.peek() == arr[i]) {
          stack.pop();
          sb.append("-\n");
          break;
        } else {
          sb = new StringBuilder("NO");
          break Label;
        }
      }
    }

    br.close();
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }
}