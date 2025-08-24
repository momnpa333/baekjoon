import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[] preOrder;
    static int[] inOrder;
    static String ans;

    static int start=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());

        while(T-->0){
            N=Integer.parseInt(br.readLine());
            preOrder=new int[N];
            inOrder=new int[N];
            ans="";
            st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                preOrder[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                inOrder[i]=Integer.parseInt(st.nextToken());
            }
            Node root=new Node(preOrder[0]);
            makeTree(root,1,N-1,0,N-1);
            postOrder(root);
            System.out.println(ans);
        }
    }
    static void postOrder(Node root){
        if(root.left!=null){
            postOrder(root.left);
        }
        if(root.right!=null){
            postOrder(root.right);
        }
        ans+=root.v+" ";
    }
    static void makeTree(Node parent,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return;
        }
        for(int i=inStart;i<=inEnd;i++){
            if(inOrder[i]==parent.v){
                if(i>inStart){
                    parent.left=new Node(preOrder[preStart]);
                    makeTree(parent.left,preStart+1,preStart+(i-inStart-1),inStart,i-1);
                }
                if(i<inEnd){
                    parent.right=new Node(preOrder[preStart+i-inStart]);
                    makeTree(parent.right,preStart+i-inStart+1,preEnd,i+1,inEnd);
                }
            }
        }

    }


    static class Node{
        int v;
        Node left;
        Node right;
        Node(int v){
            this.v=v;
        }
    }
}
