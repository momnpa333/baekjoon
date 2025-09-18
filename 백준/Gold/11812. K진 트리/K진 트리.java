import java.io.*;
import java.util.*;

public class Main {
    static Long N;
    static int K,Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Long.parseLong(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        
        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if(K==1){
                System.out.println(Math.abs(A-B));
                continue;
            }
            System.out.println(findAns(find(A),find(B)));
        }
    }
//    static int findAns(ArrayList<Long> hist1,ArrayList<Long> hist2){
//        int ret=0;
//        int i=0;
////        System.out.println(hist1);
////        System.out.println(hist2);
//
//        for(i=1;i<Math.max(hist1.size(),hist2.size());i++){
//            if(!Objects.equals(hist1.get(hist1.size()-i), hist2.get(hist2.size()-i))){
////                ret=i;
//                break;
//            }
//        }
//        i--;
////        System.out.println(i);
//        ret+=hist1.size()-i;
//        ret+=hist2.size()-i;
//        return ret;
//    }
static long findAns(ArrayList<Long> h1, ArrayList<Long> h2) {
    int i = h1.size() - 1;
    int j = h2.size() - 1;
    while (i >= 0 && j >= 0 && Objects.equals(h1.get(i), h2.get(j))) {
        i--; j--;
    }
    // 남은 비공통 부분의 노드 수(=간선 수) 합
    return (i + 1) + (j + 1);
}
    static ArrayList<Long> find(long num){
        ArrayList<Long> hist=new ArrayList<>();
        long sum=0;
        long depth=1;
        long cur=num;
        while(true){
//            System.out.println(cur);
//            System.out.println(Math.pow(K,depth-1));1
            if(cur>Math.pow(K,depth-1)){
                cur-= (long) Math.pow(K,depth-1);
                depth++;
            }
            else{
                break;
            }
        }

        for(long i=depth;i>=1;i--){
            hist.add(cur);
            cur=(cur-1)/K+1;
        }
//        System.out.println(hist);
        return hist;
    }

}
