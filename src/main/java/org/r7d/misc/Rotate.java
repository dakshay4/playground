package org.r7d.misc;

import java.util.ArrayList;
import java.util.List;

public class Rotate {

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int nums[] = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums, 4);
        for (int num : nums) {
            System.out.println(num);
        }
        List<Integer> re = new ArrayList<>();
        int[] a = re.stream().mapToInt(Integer::intValue).toArray();
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;

        int jumpIndex = size-k;
        for(int i=0;i<nums.length;i++) {
            if(size/2>=k){
                if(jumpIndex<size && i<jumpIndex) {
                    swap(nums,i, jumpIndex++);
                    if(jumpIndex>=size) jumpIndex = size-k;
                }
            }else {
                if(jumpIndex<size) swap(nums,i, jumpIndex);
                if(jumpIndex<size) jumpIndex++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
