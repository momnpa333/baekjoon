import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[] toParent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine(), " ");
            N=Integer.parseInt(st.nextToken());
            toParent=new int[N+1];
            for(int i=0;i<N-1;i++){
                st=new StringTokenizer(br.readLine()," ");
                int parent=Integer.parseInt(st.nextToken());
                int child=Integer.parseInt(st.nextToken());
                toParent[child]=parent;
            }
//            System.out.println(Arrays.toString(toParent));
            st=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            Set<Integer> parents=new HashSet<>();
            while(true){
                parents.add(A);
                A=toParent[A];
                if(A==0){
                    break;
                }
            }
            while(true){
                if(parents.contains(B)){
                    System.out.println(B);
                    break;
                }
                B=toParent[B];
            }
        }

    }
}
