public class biggest_list_solution {
    public static void main(String[] args) {
        int[] A={-7,-2,5,-4,20};
        int sum_final=getMaxSubarray(A,0,A.length-1);
        System.out.println(sum_final);

    }

    public static int getMaxCrossarray(int[] A,int low,int mid,int high){
        int maxleft=Integer.MIN_VALUE;
        int sumleft=0;
        for(int i=mid;i>=low;i--){
            sumleft+=A[i];
            if(sumleft>maxleft){
                maxleft=sumleft;
            }
        }

        int maxright=Integer.MIN_VALUE;
        int sumright=0;
        for(int i=mid+1;i<=high;i++){
            sumright+=A[i];
            if(sumright>maxright){
                maxright=sumright;
            }
        }
        return maxleft+maxright;
    }
    public static int getMaxSubarray(int[] A,int low,int high){
        if(low==high){
            return A[low];
        }
        int mid=(low+high)/2;
        int leftMax=getMaxSubarray(A,low,mid);   //求解左序列的最大和数组
        int rightMax=getMaxSubarray(A,mid+1,high);   //求解右序列的最大和数组
        int crossMax=getMaxCrossarray(A,low,mid,high);    //求解横跨中间位置的最大和数组

        // 找到最大值
        if(leftMax>=rightMax && leftMax>=crossMax){
            return leftMax;
        }else if(rightMax>=leftMax && rightMax>=crossMax){
            return rightMax;
        }else{
            return crossMax;
        }
    }
}
