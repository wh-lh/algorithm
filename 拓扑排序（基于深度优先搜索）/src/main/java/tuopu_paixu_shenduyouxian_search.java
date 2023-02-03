import java.util.ArrayList;
import java.util.List;

public class tuopu_paixu_shenduyouxian_search {
    public static void main(String[] args){
        int[][] graph={{0,1,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,1,0},{0,0,0,0,0,1,0,0,0},{0,0,1,0,1,0,0,0,0},{0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        String[] color={"W","W","W","W","W","W","W","W","W"};
        int[] pred={-1,-1,-1,-1,-1,-1,-1,-1,-1};
        List<Integer> result=new ArrayList<Integer>();
        tuopu_order(graph,color,pred,result);
        System.out.println("done");
//        int[] result=new int[color.length];
    }
    public static void tuopu_order(int[][] graph,String[] color,int[] pred,List<Integer> result){
        for(int i=0;i<color.length;i++){
            if(color[i]=="W"){
                tuopu_inner_order(graph,color,pred,result,i);
//                result.add(i);
            }
        }
    }
    public static void tuopu_inner_order(int[][] graph,String[] color,int[] pred,List<Integer> result,int i){
        color[i]="G";
        for(int j=0;j<color.length;j++){
            if(graph[i][j]==1){
                if(color[j]=="W"){
                    pred[j]=i;
                    tuopu_inner_order(graph,color,pred,result,j);

                }
            }
        }
        color[i]="B";
        result.add(i);
    }


}
