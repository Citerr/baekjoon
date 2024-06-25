import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int front = Integer.parseInt(st.nextToken());
    int rear = 0;
    int rrPt = 0;
    int res = 1;
    int length = 1;
    for (int i = 1; i < N; i++) {
      int token = Integer.parseInt(st.nextToken());
      if (rear == 0) {
        if (token != front) {
          rear = token;
          rrPt = i;
        }
        length++;
      }

      else if (token != rear) {
         if (token != front) { //new value
          front = rear;
          rear = token;

          length = i - rrPt + 1;
          rrPt = i;
        }
        else { //front == token, 앞뒤 바꾸기
          front = rear;
          rear = token;

          rrPt = i;
          length++;
        }
      }

      else { //token == rear
        length++;
      }

      res = (length > res) ? length : res;
    }
      
 
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( res + " ");
    bw.flush();
    bw.close();
  }
}