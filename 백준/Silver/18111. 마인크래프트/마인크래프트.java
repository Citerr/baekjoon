import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int time = 0;
    TreeMap<Integer, Integer> tm = new TreeMap<>();

    for (int row = 0; row < X; row++) {
      st = new StringTokenizer(br.readLine());
      for (int col = 0; col < Y; col++) {
        int elem = Integer.parseInt(st.nextToken());
        if (tm.containsKey(elem)) tm.put(elem, tm.get(elem) + 1);
        else tm.put(elem, 1);
      }
    }
    br.close();

    int fk = tm.firstKey();
    int lk = tm.lastKey();
    while (fk != lk) {
      int fv = tm.get(fk);
      int lv = tm.get(lk);

      if ( fv <= lv*2 && fv <= B) {
        B -= fv;
        time += fv;
        tm.remove(fk);
        if (tm.containsKey(++fk))
          tm.put(fk, tm.get(fk) + fv);
        else tm.put(fk, fv);

      } else { //
        B += lv;
        time += lv*2;
        tm.remove(lk);
        if (tm.containsKey(--lk))
          tm.put(lk, tm.get(lk) + lv);
        else tm.put(lk, lv);
      }
      
    } 

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(time + " " + lk);
    bw.flush();
    bw.close();
  }
}