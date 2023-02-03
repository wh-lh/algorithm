import javafx.beans.binding.MapExpression;

import java.util.*;

public class beibao_problem {
    public static void main(String[] args)
    {
//        List<List<Integer>> ans=new ArrayList<>();
//        List<Integer> inner1=new ArrayList<>();
//        List<Integer> inner2=new ArrayList<>();
//        List<Integer> inner3=new ArrayList<>();
//        List<Integer> inner4=new ArrayList<>();
//        List<Integer> inner5=new ArrayList<>();
//        inner1.add(10);   //体积
//        inner1.add(24);   //价格
//        inner2.add(3);   //体积
//        inner2.add(2);   //价格
//        inner3.add(4);   //体积
//        inner3.add(9);   //价格
//        inner4.add(5);   //体积
//        inner4.add(10);   //价格
//        inner5.add(4);   //体积
//        inner5.add(9);   //价格
//        ans.add(inner1);
//        ans.add(inner2);
//        ans.add(inner3);
//        ans.add(inner4);
//        ans.add(inner5);
//        System.out.println(ans);
        int[] p={0,24,2,9,10,9};
        int[] v={0,10,3,4,5,4};
        int[][] result_total=KnapsackDP(4,p,v,9);

        System.out.println(result_total[4][9]);



    }
    public static int[][] KnapsackDP(int n, int[] p, int[] v, int c){
        int[][]  max_price= new int [n+1][c+1];
        int[][]  Rec=new int [n+1][c+1];
        // 初始化
        for(int i=0;i<(n+1);i++){
            max_price[i][0]=0;
        }
        for(int i=0;i<(c+1);i++){
            max_price[0][i]=0;
        }
        //构造备忘录
        for(int i=1;i<(n+1);i++){
            for(int j=1;j<(c+1);j++){
                if(((v[i]<j) || (v[i]==j)) && ((p[i]+max_price[i-1][j-v[i]])>max_price[i-1][j])){
                    max_price[i][j]=p[i]+max_price[i-1][j-v[i]];
                    Rec[i][j]=1;
                }
                else{
                    max_price[i][j]=max_price[i-1][j];
                    Rec[i][j]=0;
                }
            }
        }
        int k=c;
        for(int i=n;i>0;i--){
            if(Rec[i][k]==1){
                System.out.println("选择商品"+i);
                k=k-v[i];
            }else{
                System.out.println("不选择商品"+i);
            }
        }
        return max_price;



    }


}
