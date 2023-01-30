import java.util.*;
// leet code 35.
public class SearchInsertPositionLeet35 {
    public static int searchInsert(int[] nums, int target) {
        int low =0;
        int high=nums.length-1;
        while(low<=high){
          int mid=(low+high)/2;
          System.out.println(mid);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }



    public static void main(String[]args){
        int []a= {1,3,5,6};
       int r= searchInsert(a,2);

       System.out.println(r);
     
    }
}
