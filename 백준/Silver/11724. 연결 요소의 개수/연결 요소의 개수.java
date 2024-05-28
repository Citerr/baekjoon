import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class Main {
  static ArrayList<Integer>[] edgeLists;
  static ArrayList<Integer> node = new ArrayList<>();
  static Queue<Integer> visited = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int ctr = 0;

    edgeLists = new ArrayList[N + 1];
    for (int n = 1; n < N + 1; n++) {
      node.add(n);
      edgeLists[n] = new ArrayList<>();
    }

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      edgeLists[u].add(v);
      edgeLists[v].add(u);
    }
    
    Iterator<Integer> iterator = node.iterator();
    while ( iterator.hasNext() ) {
      int i = iterator.next();
      ctr += DFS(i);
    }

    sb.append(ctr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int DFS(int n) {
    if (visited.contains(n) || edgeLists[n] == null ) return 0;
    visited.offer(n);
    //node.remove(Integer.valueOf(n));

    for (int i: edgeLists[n]) {
      DFS(i);
    }
    return 1;
  }
}