import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5639 {
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        root=new Node(Integer.parseInt(br.readLine()));

        while(true){
            String tmp=br.readLine();
            if(tmp==null||tmp.equals("")){
                break;
            }
            root.add(Integer.parseInt(tmp));
        }
        postOrder(root);

    }

    static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key=key;
        }

        void add(int item){
            if(item<this.key){
                if(this.left!=null)
                    this.left.add(item);
                else
                    this.left=new Node(item);
            }
            else{
                if(this.right!=null)
                    this.right.add(item);
                else
                    this.right=new Node(item);
            }

        }
    }

    static void postOrder(Node node){
        if(node.left!=null)
            postOrder(node.left);
        if(node.right!=null)
            postOrder(node.right);
        System.out.println(node.key);
    }


}
