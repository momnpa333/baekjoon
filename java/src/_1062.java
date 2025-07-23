import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1062 {
    static int N,K;
    static String[] words;
    static HashSet<Character> knownSet;
    static HashSet<Character> candiSet;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        knownSet=new HashSet<>();
        candiSet=new HashSet<>();
        String base="antatica";
        for(char ch:base.toCharArray()){
            knownSet.add(ch);
        }

        K-=knownSet.size();
        words=new String[N];
        for(int i=0;i<N;i++){
            words[i]=br.readLine();
            words[i]=words[i].substring(4, words[i].length()-4);
            for(char ch:words[i].toCharArray()){
                if(!knownSet.contains(ch)){
                    candiSet.add(ch);
                }
            }
        }
        if(K<0){
            System.out.println(0);
            return;
        }
//        System.out.println(K);
//        System.out.println(candiSet);
        char[] candiAry=new char[candiSet.size()];
        int idx=0;
        for(char ch:candiSet){
            candiAry[idx++]=ch;
        }
        dfs(0,0,candiAry);
        System.out.println(answer);

    }
    static void dfs(int depth,int start,char[] candiAry){
//        System.out.println(depth);
        if(depth==K || depth>=candiSet.size()){
            int cnt=0;
            for(int i=0;i<N;i++){
                cnt++;
                for(char ch:words[i].toCharArray()){
                    if(!knownSet.contains(ch)){
                        cnt--;
                        break;
                    }
                }
            }
            answer=Math.max(answer,cnt);
            return;
        }
        for(int i=start;i<candiAry.length;i++){
            if(!knownSet.contains(candiAry[i])){
                knownSet.add(candiAry[i]);
                dfs(depth+1,i+1,candiAry);
                knownSet.remove(candiAry[i]);
            }
        }


    }


}
