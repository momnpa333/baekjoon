import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static long ans;
    static Map<Integer,Integer> hist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        seq=new int[N];
        hist=new HashMap<>();
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        int left=0; int right=0;
        while(right<N){
            if(!hist.containsKey(seq[right])){
                hist.put(seq[right],right);
                right++;
            }
            else{
                while(true){
//                    System.out.printf("%d %d\n",left,right);
                    ans+=right-hist.get(seq[left]);
                    hist.remove(seq[left]);
                    if(seq[left]==seq[right]){
                        left++;
                        break;
                    }
                    left++;
                }
                hist.put(seq[right],right);
                right++;
            }
        }
        for(Integer item:hist.values()){
            ans+=N-item;
        }
        System.out.println(ans);


    }
}
