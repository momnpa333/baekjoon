import java.io.*;
import java.util.*;

public class Main {
    static int purchase;
    static int m,n;
    static int[] mList;
    static int[] nList;
    static Map<Integer,Integer> dicA=new HashMap<>();
    static Map<Integer,Integer> dicB=new HashMap<>();
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        purchase=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        mList=new int[m*2];
        nList=new int[n*2];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            mList[i]=Integer.parseInt(st.nextToken());
            mList[i+m]=mList[i];
        }

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            nList[i]=Integer.parseInt(st.nextToken());
            nList[i+n]=nList[i];
        }
        makeDic(mList,dicA);
        makeDic(nList,dicB);
        
        findCase();
        System.out.println(answer);
    }
    static void findCase(){
        for(int key: dicA.keySet()){
            if(dicB.containsKey(purchase-key)){
                answer+=dicA.get(key)*dicB.get(purchase-key);
            }
        }
        answer+=dicA.getOrDefault(purchase,0);
        answer+=dicB.getOrDefault(purchase,0);
    }
    static void makeDic(int[] list,Map<Integer,Integer> dic){
        int l=list.length/2;
        int[] sum=new int[list.length+1];

        for(int i=1;i<=list.length;i++){
            sum[i]=list[i-1]+sum[i-1];
        }
//        System.out.println(Arrays.toString(list));
//        System.out.println(Arrays.toString(sum));
        for(int size=1;size<l;size++){
            for(int start=0;start<l;start++){
                int pizzaSize=sum[start+size]-sum[start];
                int v=dic.getOrDefault(pizzaSize,0);
                dic.put(pizzaSize,v+1);
            }
        }
        dic.put(sum[l]-sum[0],1);
    }
}
