import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
  static ArrayList<Integer> heap = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    for (int n = 0; n < N; n++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if ( heap.isEmpty() ) sb.append("0\n");
        else sb.append(del()  + "\n");
      }
      else {
        insert(x);
      }
    }
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int swap(int a, int b) {
    int temp = heap.get(a);
    heap.set(a, heap.get(b));
    heap.set(b, temp);
    return a;
  }

  static void insert(int x) {
    heap.add(x);
    int addNode = heap.size() - 1;

    while(addNode != 0) {
      if ( (addNode-1)%2 == 0 ) { //홀수노드
        if ( heap.get( (addNode-1)/2 ) > x )
          addNode = swap((addNode-1)/2, addNode);
        else break;
      }
      else {  //짝수노드
        if ( heap.get( (addNode-2)/2 ) > x )
          addNode = swap((addNode-2)/2, addNode);
        else break;
      }
    }

  }

  static int del() {
    int root = heap.get(0);
    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);
    int node = 0;
    while (2*node + 1 < heap.size()) {
      int leftNode = 2*node + 1;
      int rightNode = 2*node + 2;
      if (rightNode < heap.size())
        leftNode = (heap.get(leftNode) < heap.get(rightNode)) ? leftNode : rightNode;

      if (heap.get(node) > heap.get(leftNode)) {
        node = swap(leftNode, node);
      }
      else break;
    }
    return root;
  }
}