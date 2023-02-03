import java.util.List;

public class zuida_zishuzu {
    public static void main(String[] args) {
//        int[] A={4,2,3,-5,3,1};
        int[] A={4,2,3,-5,3,1};
        int[] result=new int[A.length];    //记录结果数组
        int[] process=new int[A.length];    //记录过程节点数组
        int[] result_list=Count_max(A,result,process);
        for(int i=0;i<result_list.length;i++){
            System.out.println(result_list[i]);
        }


    }
    public static int[] Count_max(int[] A,int[] result,int[] process){
        for (int i=A.length-1;((i>0)||(i==0));i--){
            if((i+1)==A.length){
                result[i]=A[i];
                process[i]=i;
            }else {
                if(result[i+1]>0){
                    result[i]=A[i]+result[i+1];
                    process[i]=process[i+1];
                }else if(result[i+1]<0){
                    result[i]=A[i];
                    process[i]=i;
                }
            }

        }
        int max_num=result[0];
        int start=0;
        int end=0;
        int[] array = new int[3];
        for (int i=0;i<A.length;i++){
            if((max_num<result[i])||(max_num==result[i]) ){
                max_num=result[i];
                start=i;
                end=process[i];
            }
        }
        array[0]=max_num;
        array[1]=start;
        array[2]=end;
        return array;
    }
}
