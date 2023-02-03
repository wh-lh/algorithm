import java.util.*;

public class qiangliantong_fenliang {
    public static void main(String[] args) {
        int[][] graph={{0,0,1,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,0,0},{1,0,0,0,0,1,0,0,0,0},{0,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,1,1,0,0},{1,0,0,0,0,0,0,0,0,0}};
        int[][] zhuanzhi_graph=new int[10][10];
        zhuanzhi_operate(graph,zhuanzhi_graph);

        List<Integer> record=new ArrayList<Integer>();
//        List<Integer> record_part=new ArrayList<Integer>();
        List<List<Integer>> record_result=new ArrayList<List<Integer>>();
        String[] color={"W","W","W","W","W","W","W","W","W","W"};
        shendu_youxian_first_search(zhuanzhi_graph,record,color);
        shendu_youxian_second_search(graph,record,color,record_result);
        System.out.println("done");


    }
    public static void zhuanzhi_operate(int[][] graph,int[][] zhuanzhi_graph){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                zhuanzhi_graph[j][i]=graph[i][j];
            }
        }
    }
    public static void shendu_youxian_first_search(int[][] zhuanzhi_graph,List<Integer> record,String[] color){
        for(int i=0;i< color.length;i++){
            if(color[i]=="W"){
                DFS_visit(zhuanzhi_graph,record,color,i);
            }
        }
    }
    public static void DFS_visit(int[][] zhuanzhi_graph,List<Integer> record,String[] color,int i){
        color[i]="G";
        for(int j=0;j<color.length;j++){
            if(zhuanzhi_graph[i][j]==1){
                if(color[j]=="W"){
                    DFS_visit(zhuanzhi_graph,record,color,j);
                }
            }
        }
        color[i]="B";
        record.add(i);


    }
    public static void shendu_youxian_second_search(int[][] graph,List<Integer> record,String[] color,List<List<Integer>> record_result){
        for(int i=0;i< color.length;i++){
            color[i]="W";
        }
        for(int i=record.size()-1;i>-1;i--){
            if(color[record.get(i)]=="W"){
                List<Integer> record_part=new ArrayList<Integer>();
                DFS_visit2(graph,color,record.get(i),record_part);
                record_result.add(record_part);
//                record_part.clear();
            }
        }
    }
    public static void DFS_visit2(int[][] graph,String[] color,int i,List<Integer> record_part){
        color[i]="G";
        for(int j=0;j<color.length;j++){
            if(graph[i][j]==1){
                if(color[j]=="W"){
                    DFS_visit2(graph,color,j,record_part);
                }
            }
        }
        color[i]="B";
        record_part.add(i);
    }
}
