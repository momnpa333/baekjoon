import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] items;
    static long maxPossible;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        items=new int[N+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            items[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items);

        for(int i=1;i<=N;i++){
            if(maxPossible+1<items[i]){
                System.out.println(maxPossible+1);
                return;
            }
            maxPossible+=items[i];
        }
        System.out.println(maxPossible+1);


    }
}

