// https://leetcode.com/problems/move-zeroes


class Solution {
    public static void main(String[] args) {
        int nums[]={0,1,0,3,12};
        moveZeroes(nums);
        for(int i:nums)
        System.out.print(i+" ");
    }
    public static void moveZeroes(int[] nums) {
        
        int firstZeroOccurence=-1;
        
        for(int i=0;i<nums.length;i++)
        {
            
            if(nums[i]!=0)
            {
                if(firstZeroOccurence!=-1)
                {
                    int temp = nums[i];
                    nums[i]=0;
                    nums[firstZeroOccurence] = temp;
                    firstZeroOccurence++;
                }
            }
            else 
            {
                if(firstZeroOccurence==-1)
                    firstZeroOccurence = i;
            }
        }
        
    }
}