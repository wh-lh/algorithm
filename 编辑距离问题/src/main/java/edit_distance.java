import java.util.*;

public class edit_distance {
    public static void main(String[] args) {
        String[] A={"A","B","C","B","D","A","B"};
        String[] B={"B","D","C","A","B","A"};
        int[][] result=new int[A.length+1][B.length+1];
        int[][] record=new int[A.length+1][B.length+1];
        edit(A,B,result,record);
        int longest_operate=result[A.length][B.length];
        System.out.println("最小操作数为"+longest_operate);
        print_process(record,A.length,B.length,A,B);

//        int[] c={2,1,4};
//        Arrays.sort(c);
//        System.out.println(c[0]);

    }
    public static void edit(String[] A,String[] B,int[][] result,int[][] record){
        for(int i=0;i<A.length+1;i++){
            result[i][0]=i;
            record[i][0]=2;
        }
        for(int i=0;i<B.length+1;i++){
            result[0][i]=i;
            record[0][i]=1;
        }
        record[0][0]=0;
        for(int i=1;i<A.length+1;i++){
            for(int j=1;j<B.length+1;j++){
//                List<Integer> c=new ArrayList<Integer>();
//                Map<Integer,Integer> map=new HashMap<>();
//                map.put(result[i][j-1]+1,1);
//                map.put(result[i-1][j]+1,2);
//                if(A[i-1]==B[j-1]){
//                    map.put(result[i-1][j-1],4);
//                }else if(A[i-1]!=B[j-1]){
//                    map.put(result[i-1][j-1]+1,3);
//                }
//                Set set=map.keySet();
//                Object[] arr=set.toArray();
//                Arrays.sort(arr);
//                for(Object key:arr){
//                    System.out.println(key);
//                }
//
//                System.out.println(map);

                int a=result[i][j-1]+1;
                int b=result[i-1][j]+1;
                int d=100000;
                if(A[i-1]==B[j-1]){
                    d=result[i-1][j-1];
                }else if(A[i-1]!=B[j-1]){
                    d=result[i-1][j-1]+1;
                }
                int min=(a<b)?(a<d?a:d):(b<d?b:d);
                result[i][j]=min;
                if(min==a){
                    record[i][j]=1;
                }else if(min==b){
                    record[i][j]=2;
                }else if(min==d){
                    record[i][j]=3;
                }



//                //插入操作
//                c.add(result[i][j-1]+1);
//                //删除操作
//                c.add(result[i-1][j]+1);
//                //替换操作
//                if(A[i-1]==B[j-1]){
//                    c.add(result[i-1][j-1]);
//                }
//                if(A[i-1]!=B[j-1]){
//                    c.add(result[i-1][j-1]+1);
//                }
//                Collections.sort(c);
//                result[i][j]=c.get(0);
//                if(c.get(0)==result[i][j-1]+1){
//                    record[i][j]=1;   //插入操作
//                }else if(c.get(0)==result[i-1][j]+1){
//                    record[i][j]=2;  //删除操作
//                }else if(c.get(0)==result[i-1][j-1]+1){
//                    record[i][j]=3;  //替换操作
//                }else if(c.get(0)==result[i-1][j-1]){
//                    record[i][j]=4;  //无操作
//                }
            }
        }

    }

    public static void print_process(int[][] record,int i,int j,String[] A,String[] B){
        if(i==0 && j==0){
            System.out.println("过程结束");
        }else{
            if(record[i][j]==3 && A[i-1]==B[j-1]){
                print_process(record,i-1,j-1,A,B);
                System.out.println("无操作");
            }else if(record[i][j]==3 && A[i-1]!=B[j-1]){
                print_process(record,i-1,j-1,A,B);
                System.out.println("用"+B[j-1]+"替换"+A[i-1]);
            }else if(record[i][j]==2){
                print_process(record,i-1,j,A,B);
                System.out.println("删除"+A[i-1]);
            }else if(record[i][j]==1){
                print_process(record,i,j-1,A,B);
                System.out.println("插入"+B[j-1]);
            }
        }
    }
}
