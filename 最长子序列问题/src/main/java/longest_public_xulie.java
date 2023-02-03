import java.util.ArrayList;
import java.util.List;

public class longest_public_xulie {
    public static void main(String[] args) {
        String[] A={"A","B","C","B","D","A","B"};
        String[] B={"B","D","C","A","B","B"};

        int[][] result=new int[A.length+1][B.length+1];    //最大子序列长度结果数组
        int[][] record=new int[A.length+1][B.length+1];    //追踪数组

        int zixulie_len=longest(A,B,result,record);
        print_zixulie(A,B,record);
        System.out.println(zixulie_len);
    }
    public static int longest(String[] A,String[] B,int[][] result,int[][] record){
        //对result数组进行初始化
        for(int i=0;i<A.length+1;i++){
            result[i][0]=0;
            record[i][0]=-1;
        }
        for(int i=0;i<B.length+1;i++){
            result[0][i]=0;
            record[0][i]=-1;
        }
        //根据递推关系填表
        for(int i=1;i<A.length+1;i++){
            for(int j=1;j<B.length+1;j++){
                if(A[i-1]==B[j-1]){
                    result[i][j]=result[i-1][j-1]+1;
                    record[i][j]=2;
                }else if(A[i-1]!=B[j-1]){
                    if(result[i-1][j]>result[i][j-1] || result[i-1][j]==result[i][j-1]){
                        result[i][j]=result[i-1][j];
                        record[i][j]=1;
                    }else{
                        result[i][j]=result[i][j-1];
                        record[i][j]=0;
                    }
                }
            }
        }
        return result[A.length][B.length];
    }
    public static void print_zixulie(String[] A,String[] B,int[][] record){

        List<String> D=new ArrayList<String>();
        int i=A.length;
        int j=B.length;
        while(record[i][j] != -1){
            if(record[i][j]==2){
                D.add(A[i-1]);
                i=i-1;
                j=j-1;
            }else if(record[i][j]==1){
                i=i-1;
            }else if(record[i][j]==0){
                j=j-1;
            }
        }
//        System.out.println(D.size());
//        System.out.println(D);
        for (int t=0;t<D.size();t++){
            System.out.println(D.get(D.size()-1-t));
        }
    }

}
