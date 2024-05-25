import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] paper;
  static boolean full = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for(int n = 0; n < N; n++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int m = 0; m < N; m++) 
        paper[n][m] = Integer.parseInt(st.nextToken());
    }
        
    sb.append(whitePaper(0, 0, N - 1, N - 1) + "\n" + (bluePaper(0, 0, N - 1, N - 1)));
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int bluePaper(int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      if (paper[x1][y1] == 1) {
        full = true;
        return 1;
      }
      else return 0;
    }
    int chk = 0;
    full = false;

    int Fst = bluePaper(x1, y1, (x1 + x2)/2, (y1 + y2)/2);
    if (full == true) {
      full = false;
      chk++;
    }
    int Snd = bluePaper((x1 + x2)/2 + 1, y1, x2, (y1 + y2)/2);
    if (full == true) {
      full = false;
      chk++;
    }
    int Trd = bluePaper(x1, (y1 + y2)/2 + 1, (x1 + x2)/2, y2);
    if (full == true) {
      full = false;
      chk++;
    }
    int Fth = bluePaper((x1 + x2)/2 + 1, (y1 +y2)/2 + 1, x2, y2);
    if (full == true) {
      full = false;
      chk++;
    }

    if (chk == 4) {
      full = true;
      return 1;
    }
    
    return Fst + Snd + Trd + Fth;
  }

  static int whitePaper(int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      if (paper[x1][y1] == 0) {
        full = true;
        return 1;
      }
      else return 0;
    }
    int chk = 0;
    full = false;


    int Fst = whitePaper(x1, y1, (x1 + x2)/2, (y1 + y2)/2);
    if (full == true) {
      full = false;
      chk++;
    }
    int Snd = whitePaper((x1 + x2)/2 + 1, y1, x2, (y1 + y2)/2); 
    if (full == true) {
      full = false;
      chk++;
    }
    int Trd = whitePaper(x1, (y1 + y2)/2 + 1, (x1 + x2)/2, y2);
    if (full == true) {
      full = false;
      chk++;
    }
    int Fth = whitePaper((x1 + x2)/2 + 1, (y1 +y2)/2 + 1, x2, y2);
    if (full == true) {
      full = false;
      chk++;
    }

    if (chk == 4) {
      full = true;
      return 1;
    }
    
    //if (Fst == 1 && Snd == 1 && Trd == 1 && Fth == 1) return 1;
    
    return Fst + Snd + Trd + Fth;
  }
}