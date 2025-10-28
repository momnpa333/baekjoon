import java.io.*;
import java.util.*;

public class Main {
    static Map<String,Integer> folderIdx=new HashMap<>();
    static Folder[] folders;
    static int curIdx;
    static int N,M;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        folders=new Folder[N+1];

        for(int i=0;i<N+M;i++){
            st=new StringTokenizer(br.readLine()," ");
            String P=st.nextToken();
            String F=st.nextToken();
            int C=Integer.parseInt(st.nextToken());

            if(folderIdx.containsKey(P)){
                if(C==1){
                    if(folderIdx.containsKey(F)){
                        folders[folderIdx.get(P)].putFolder(findFolder(F));
                    }
                    else{
                        Folder f=new Folder(F);
                        folderIdx.put(F,curIdx);
                        folders[curIdx++]=f;
                        folders[folderIdx.get(P)].putFolder(folders[folderIdx.get(F)]);
                    }
                }
                else{
                    Folder parent=findFolder(P);
                    parent.putFile(F);
                }
            }
            else{
                Folder nf=new Folder(P);
                folderIdx.put(P,curIdx);
                folders[curIdx++]=nf;
                if(C==1){
                    if(folderIdx.containsKey(F)){
                        folders[folderIdx.get(P)].putFolder(folders[folderIdx.get(F)]);
                    }
                    else{
                        Folder f=new Folder(F);
                        folderIdx.put(F,curIdx);
                        folders[curIdx++]=f;
                        folders[folderIdx.get(P)].putFolder(folders[folderIdx.get(F)]);
                    }
                }
                else{
                    Folder parent=findFolder(P);
                    parent.putFile(F);
                }
            }

        }

        st=new StringTokenizer(br.readLine()," ");
        Q=Integer.parseInt(st.nextToken());
        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine());
            String cmd=st.nextToken();
            String[] tmp=cmd.split("/");
//            System.out.println(tmp[tmp.length-1]);
            System.out.println(ans(tmp[tmp.length-1]));
        }
    }
    static String ans(String name){
        Set<String> fs=new HashSet<>();
        Folder f=findFolder(name);
        int totalCnt=solve(fs,f);
        return fs.size()+" "+totalCnt;
    }
    static int solve(Set<String> files,Folder f){
        int totalCnt=f.files.size();
        files.addAll(f.files);
        for(Folder fd:f.childs){
            totalCnt+=solve(files,fd);
        }
        return totalCnt;
    }
    static Folder findFolder(String name){
        int idx=folderIdx.get(name);
        return folders[idx];
    }
    static class Folder{
        ArrayList<String> files;
        ArrayList<Folder> childs;
        String name;
        Folder(String name){
            this.name=name;
            files=new ArrayList<>();
            childs=new ArrayList<>();
        }
        void putFile(String file){
            files.add(file);
        }
        void putFolder(Folder folder){
            childs.add(folder);
        }
    }
}