public class longest_public_zichuan {
    public static void main(String[] args) {
        String[] A={"A","B","C","A","D","B","B"};
        String[] B={"B","C","E","D","B","B"};
        int[][] result=new int[A.length+1][B.length+1];
        find_public_zichuan(A,B,result);



    }
    public static void find_public_zichuan(String[] A,String[] B,int[][] result){
        int max=0;
        int position=0;
        for(int i=0;i<A.length+1;i++){
            result[i][0]=0;
        };
        for(int i=0;i<B.length+1;i++){
            result[0][i]=0;
        };
        for(int i=1;i<A.length+1;i++){
            for(int j=1;j<B.length+1;j++){
                if(A[i-1]==B[j-1]){
                    result[i][j]=result[i-1][j-1]+1;
                    if(result[i][j]>max){
                        max=result[i][j];
                        position=i;
                    }
                }else if(A[i-1]!=B[j-1]){
                    result[i][j]=0;
                }
            }
        }
        System.out.println("最大公共子串长度为"+max);
        System.out.println("最大公共子串为");
        for(int i=position-max;i<position;i++){
            System.out.println(A[i]);
        }
    }
}
