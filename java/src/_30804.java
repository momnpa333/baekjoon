import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _30804 {
    static int N;
    static int[] fruits;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        fruits=new int[N];
        for(int i=0;i<N;i++){
            fruits[i]=Integer.parseInt(st.nextToken());
        }

        int left=0; int right=0; int answer=0;
        Map<Integer,Integer> fruitDict=new HashMap<>();
        Set<Integer> fruitSet=new HashSet<>();
        fruitDict.put(fruits[left],1);
        fruitSet.add(fruits[left]);
        while(right<N){
//            System.out.printf("%d %d %d\n",left,right,fruitSet.size());
            if(fruitSet.size()>2){
                fruitDict.put(fruits[left],fruitDict.get(fruits[left])-1);
                if (fruitDict.get(fruits[left])==0){
                    fruitSet.remove(fruits[left]);
                }
                left+=1;
            }
            else{
                answer=Math.max(answer,right-left+1);
                right+=1;
                if(right<N){
                    fruitDict.put(fruits[right],fruitDict.getOrDefault(fruits[right],0)+1);
                    fruitSet.add(fruits[right]);
                }
            }
        }
        System.out.println(answer);
    }

}
