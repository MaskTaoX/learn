package javaTest3;

import java.util.Arrays;

/**
 * 快慢指针去重问题
 */
public class sort03 {
    public static void main(String[] args) {
        int[] nums = {3,4,1,4,3,1,2,5};
        Arrays.sort(nums);
        int[] res = sort(nums);
        Arrays.stream(nums).forEach(System.out::print);


    }
    //复杂度为n， 相等就移动快指针j,不相等就移动慢指针i，并赋值给nums[i]=nums[j]
    public static int[] sort(int[] nums){
        int i = 0;
        for(int j = 1; j<nums.length; j++){
            if(nums[i]!=nums[j]){
              nums[i+1]=nums[j];
              i++;
            }
        }
        return nums;
    }
}
