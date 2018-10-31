package com.sakura.tools;

import java.lang.reflect.Array;
import java.util.Arrays;

//算法练习
public class Algorithm {


    /**
     * 2018,07,23
     *
     */
    public static int removeDuplicates(int[] nums,String sakura){
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                    if(nums[i] == nums[j+1]){
                        nums[i] = nums[nums.length - 1];
                        continue;
                    }
            }

        }
        Arrays.sort(nums);
        for (int a:nums
             ) {
            m += 1;
            if(a == nums[nums.length - 1]){
                break;
            }
        }

        return m;
    }

    /**
     * 解
     */
    public static int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int number = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != nums[number]){
                number++;
                nums[number] = nums[i];
            }
        }
        number += 1;
        for (int a:nums
             ) {
            System.out.println(a);
        }
        return number;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,2,3,3,3,4,4,4,5};
        System.out.println(removeDuplicates(nums));
    }
}
