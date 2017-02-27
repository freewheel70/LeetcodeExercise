package leetcode;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/9.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {6,7,5,3,5,6,2,9,1,2,7,0,9};
        new NextPermutation().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        // write your code here
        if(nums==null || nums.length == 1) return;

        //      3 4 2 1 -> 4 1 2 3
        //      3 7 6 4 -> 4 7 6 3 -> 4 3 6 7
        int len = nums.length;
        boolean found = false;
        int targetIndex = -1;
        for(int i = len-2; i >=0; i--){
            if(nums[i]<nums[i+1]){
                found = true;
                targetIndex = i;
                break;
            }
        }

        if(found){

            for(int i = len-1; i > targetIndex; i--){
                if(nums[i] > nums[targetIndex]){
                    swap(nums, i, targetIndex);
                    break;
                }
            }

            int start = targetIndex + 1;
            int end = len - 1;
            while(start < end){
                swap(nums,start,end);
                start++;
                end--;
            }

        }else{
            int i = 0;
            int j = len -1;
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public void nextPermutation(int[] nums) {
//        if(nums.length<=1){
//            return;
//        }
//
//        int i= nums.length-1;
//
//        for(;i>=1;i--){
//
//            if(nums[i]>nums[i-1]){ //find first number which is smaller than it's after number
//                break;
//            }
//        }
//
//        if(i!=0){
//            swap(nums,i-1); //if the number exist,which means that the nums not like{5,4,3,2,1}
//        }
//
//        reverse(nums,i);
//    }
//
//    private void swap(int[] a,int target){
//        for(int j = a.length-1;j>target;j--){
//            if(a[j]>a[target]){
//                int t = a[j];
//                a[j] = a[target];
//                a[target] = t;
//                break;
//            }
//        }
//    }
//
//    private void reverse(int[] a,int i){//reverse the number after the number we have found
//        int first = i;
//        int last = a.length-1;
//        while(first<last){
//            int t = a[first];
//            a[first] = a[last];
//            a[last] = t;
//            first ++;
//            last --;
//        }
//    }
}
