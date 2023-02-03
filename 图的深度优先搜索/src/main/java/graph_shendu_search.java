public class graph_shendu_search {
    static int time=0;
    public static void main(String[] args) {

        int[][] graph={{0,1,0,0,1,0,0,0},{1,0,0,0,0,1,0,0},{0,0,0,1,0,1,1,0},{0,0,1,0,0,0,1,1},
                {1,0,0,0,0,0,0,0},{0,1,1,0,0,0,1,0},{0,0,1,1,0,1,0,1},{0,0,0,1,0,0,1,0}};
        String[] color={"W","W","W","W","W","W","W","W"};
        int[] pred={-1,-1,-1,-1,-1,-1,-1,-1};
        int[] start_time=new int[8];
        int[] end_time=new int[8];
        shendu_search(graph,color,pred,start_time,end_time);
        System.out.println("done");
    }
    public static void shendu_search(int[][] graph,String[] color,int[] pred,int[] start_time,int[] end_time){

        for(int i=0;i<start_time.length;i++){
            if(color[i]=="W"){
                DFS_visit(graph,color,pred,start_time,end_time,i);
            }
        }
    }

    public static void DFS_visit(int[][] graph,String[] color,int[] pred,int[] start_time,int[] end_time,int i){
        color[i]="G";
        time=time+1;
        start_time[i]=time;
        for(int j=0;j<start_time.length;j++){
            if(graph[i][j]==1){
                if(color[j]=="W"){
                    pred[j]=i;
                    DFS_visit(graph,color,pred,start_time,end_time,j);
                }
            }
        }
        color[i]="B";
        time=time+1;
        end_time[i]=time;
    }
}
