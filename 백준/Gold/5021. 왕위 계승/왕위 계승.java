import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Map<String,Item> infoMap;
    static String king;
    static final int INF=987654321;
    static double candiDna=-1;
    static String candi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        infoMap=new HashMap<>();
        king=br.readLine();
        Item k=new Item(king,"","");
        k.dna=1;
        infoMap.put(king,k);
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            String name=st.nextToken();
            String p1=st.nextToken();
            String p2=st.nextToken();
            Item item=new Item(name,p1,p2);
            infoMap.put(name,item);
        }
        for(int i=0;i<M;i++){
            String tmp=br.readLine();
            //System.out.println(tmp);
            Item item=infoMap.getOrDefault(tmp,null);
            double tmpDna=0;
            if(item!=null)
                tmpDna=item.getDna();
            if(tmpDna>candiDna){
                candiDna=tmpDna;
                candi=tmp;
            }
        }
        System.out.println(candi);


    }
    static class Item{
        String name;
        String p1;
        String p2;
        double dna=-1;
        Item(String name,String p1,String p2){
            this.name=name;
            this.p1=p1;
            this.p2=p2;
        }
        double getDna(){
            if(dna!=-1){
                return dna;
            }
            Item parent1=infoMap.getOrDefault(p1,null);
            Item parent2=infoMap.getOrDefault(p2,null);
            double p1Dna=0;
            double p2Dna=0;
            if(parent1!=null){
                p1Dna= parent1.getDna();
            }
            if(parent2!=null){
                p2Dna= parent2.getDna();
            }
            this.dna=(p1Dna+p2Dna)/2;
            return this.dna;
        }
    }
}
