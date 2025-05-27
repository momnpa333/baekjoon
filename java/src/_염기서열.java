import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _염기서열 {
    static int N;
    static int M;
    static String[] stringAry;
    static List<String> candiList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());

        stringAry= new String[N];
        candiList=new ArrayList<>();

        for(int i=0;i<N;i++){
            stringAry[i]=br.readLine();
        }
        Arrays.sort(stringAry, (a, b) -> {
            long countA = a.chars().filter(c -> c == '.').count();
            long countB = b.chars().filter(c -> c == '.').count();
            return Long.compare(countA, countB);
        });

//        System.out.println(Arrays.toString(stringAry));

        candiList.add(stringAry[0]);

        A:
        for(int i=1;i<N;i++){
            int L=candiList.size();
            for(int j=0;j<L;j++){
//                System.out.printf("%s %s\n",stringAry[i],candiList.get(j));
                if(isPossible(stringAry[i],candiList.get(j),j)){
                    continue A;
                }
            }
            candiList.add(stringAry[i]);
        }

        System.out.println(candiList.size());

    }
    private static boolean isPossible(String st1,String st2,int idx){
        char[] s1=st1.toCharArray(); char[] s2=st2.toCharArray();
        String ret="";
        for(int i=0;i<M;i++){
            if(s1[i]=='.'||s2[i]=='.'||s1[i]==s2[i]){
                if(s1[i]=='.'&&s2[i]=='.'){
                    ret+='.';
                }
                else if(s1[i]!='.'){
                    ret+=Character.toString(s1[i]);
                }
                else if(s2[i]!='.'){
                    ret+=Character.toString(s2[i]);
                }
            }
            else{
                return false;
            }
        }
        candiList.add(idx,ret);
        candiList.remove(idx+1);
        return true;
    }

}
