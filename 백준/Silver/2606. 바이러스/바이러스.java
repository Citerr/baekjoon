import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  static ArrayList<Integer>[] edgeLists;
  static HashSet<Integer> infested = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int Node = Integer.parseInt(br.readLine());
    int Edge = Integer.parseInt(br.readLine());
    edgeLists = new ArrayList[Node + 1];

    for (int i = 1; i < Node + 1; i++) {
      edgeLists[i] = new ArrayList<>();
    }

    for (int i = 0; i < Edge; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int oneNode = Integer.parseInt(st.nextToken());
      int anotherNode = Integer.parseInt(st.nextToken());
      edgeLists[anotherNode].add(oneNode);
      edgeLists[oneNode].add(anotherNode);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(DFS(1) + "");
    bw.flush();
    bw.close(); 
  }

  static int DFS(int x) {
    if (edgeLists[x] == null) return 0;
    if (infested.contains(x)) return 0;
    infested.add(x);
    
    for (int i: edgeLists[x]) {
      DFS(i); //error
    }
    return infested.size() - 1;
  }
}