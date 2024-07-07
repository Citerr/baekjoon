import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String str = new String(br.readLine());
    
    Queue<Integer> blocckQ = new LinkedList<>();
    int idx = str.indexOf("IOI");
    while (idx != -1) {
      int block = 1;
      for (int i = idx + 3; i < M; i++) {
        if ( (i - idx)%2 == 0 &&  str.charAt(i) == 'I') block++;
        else if ( (i - idx)%2 == 1 && str.charAt(i) == 'O') continue;
        else break;
        //System.out.println(block + " " + i);
      }
      blocckQ.offer(block);
      idx = str.indexOf("IOI", idx + block*2 + 1);
      //System.out.println(block + " " + idx);
    }

    /*System.out.print("Q: ");
    for (Integer integer : blocckQ) {
      System.out.print(" " + integer);
    }
    System.out.println();*/

    int RES = 0;
    while ( !blocckQ.isEmpty() ) {
      int temp = blocckQ.poll() - (N - 1);
      RES += temp > 0 ? temp : 0;
      //System.out.println( RES );
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( RES + "" );
    bw.flush();
    bw.close();
  }
}

//가장 큰 덩어리 하나 찾고 그 크기를 줄이는 방법
//N = 2M + 1
//10101..로 되어 있는 덩어리의 크기를 알면 개수도 알 수 있다...