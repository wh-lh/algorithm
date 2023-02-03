public class cixuxuanze {
    public static void main(String[] args) {
//        int[] A={2,6,7,1,3,5,6,4};
        int[] A={21,17,37,28,13,14,22,52,40,24,48,4,47,8,42,18};
        int request=2;
        Find_Right(A,0,A.length-1,request);


    }
    public static int Partition(int[] A,int p,int r){    //p为起始位置   r为终点位置
        int i=p-1;
        int x=A[r];
        for(int j=p;j<r;j++){
            if(A[j]<x){
                int pro=A[i+1];
                A[i+1]=A[j];
                A[j]=pro;
                i=i+1;
            }
        }
        int pro2=A[i+1];
        A[i+1]=A[r];
        A[r]=pro2;
        int q=i+1;
        //返回数组划分的分界线q
        return q;
    }

    public static void Find_Right(int[] A,int p,int r,int request){
        if(p<r){
            int q=Partition(A,p,r);
            if(request<q-p+1){
                Find_Right(A,p,q-1,request);
            }else if(request>q-p+1){
                Find_Right(A,q+1,r,request-q+p-1);
            }else if(request==q-p+1){
                System.out.println(A[q]);
            }
        }
    };


}
