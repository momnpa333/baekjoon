import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        List<int[]>ansList=new ArrayList<>();

        while(N-->0){
            int[] input= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ansList.add(input);
        }
        Collections.sort(ansList,((o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]));

        for(int[] v:ansList){
            bw.append(v[0]+" "+v[1]+"\n");
        }
        bw.flush();
        bw.close();

    }
}