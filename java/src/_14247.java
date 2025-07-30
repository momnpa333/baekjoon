import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14247 {
    static int N;
    static Tree[] trees;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        trees=new Tree[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            trees[i]=new Tree(Integer.parseInt(st.nextToken()),0);
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            trees[i].growth=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
//        System.out.println(Arrays.toString(trees));
        for(int i=0;i<N;i++){
            answer+=trees[i].h+ (long) trees[i].growth *i;
        }
        System.out.println(answer);

    }
    static class Tree implements Comparable<Tree>{
        int h;
        int growth;
        Tree(int h,int growth){
            this.h=h;
            this. growth=growth;
        }
        public String toString(){
            return h+" "+growth;
        }
        public int compareTo(Tree o){
            return this.growth-o.growth;
        }
    }

}
