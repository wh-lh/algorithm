import java.util.LinkedList;
import java.util.Queue;

public class guangduyouxian_search {
    public static void main(String[] args) {
        int[][] graph={{0,1,0,0,1,0,0,0},{1,0,0,0,0,1,0,0},{0,0,0,1,0,1,1,0},{0,0,1,0,0,0,1,1},
                {1,0,0,0,0,0,0,0},{0,1,1,0,0,0,1,0},{0,0,1,1,0,1,0,1},{0,0,0,1,0,0,1,0}};
        String[] color={"W","W","W","W","W","W","W","W"};
        int[] pred={-1,-1,-1,-1,-1,-1,-1,-1};
        int[] dist={1000,1000,1000,1000,1000,1000,1000,1000};
        Queue<Integer> queue=new LinkedList<>();
        guangdu_search(graph,color,pred,dist,queue,1);

//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.poll();
//        queue.poll();
        System.out.println(queue);
    }
    public static void guangdu_search(int[][] graph,String[] color,int[] pred,int[] dist,Queue<Integer> queue,int s){
        color[s]="G";
        dist[s]=0;
        queue.add(s);
        while(!queue.isEmpty()){
            int u=queue.poll();
            for(int i=0;i<graph[u].length;i++){
                if(graph[u][i]==1){
                    if(color[i]=="W"){
                        color[i]="G";
                        pred[i]=u;
                        dist[i]=dist[u]+1;
                        queue.add(i);
                    }
                }
            }
            color[u]="B";
        }
    }
}
