package service;

public class Array2 {

    /*
    Return the number of even ints in the given array.
    Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
    
    countEvens([2, 1, 2, 3, 4]) → 3
    countEvens([2, 2, 0]) → 3
    countEvens([1, 3, 5]) → 0 
    */
    public int countEvens(int[] nuns) {
        int count = 0;
        for (int i=0; i<nuns.length; i++) {
            if (nuns[i]%2 == 0) count++;
        }
        return count;
    }

    /*
    Given an array length 1 or more of ints,
    return the difference between the largest and smallest values in the array.
    Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods 
    return the smaller or larger of two values.
        
    bigDiff([10, 3, 5, 6]) → 7
    bigDiff([7, 2, 10, 9]) → 8
    bigDiff([2, 10, 7, 2]) → 8
     */
    public int bigDiff(int[] nums) {
        if (nums.length == 1) return 0;
        int vMim = nums[0];
        int vMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            vMim = Math.min(nums[i], vMim);
            vMax = Math.max(nums[i], vMax);
        }
        return vMax - vMim;
    }
    
    /*
    Return the "centered" average of an array of ints, 
    which we'll say is the mean average of the values, 
    except ignoring the largest and smallest values in the array. 
    If there are multiple copies of the smallest value, 
    ignore just one copy, and likewise for the largest value. 
    Use int division to produce the final average. 
    You may assume that the array is length 3 or more.

    centeredAverage([1, 2, 3, 4, 100]) → 3
    centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
    centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
    centeredAverage([100, 0, 5, 3, 4]) → 4
    centeredAverage([4, 0, 100]) → 4
    centeredAverage([1000, 0, 1, 99]) → 50
    centeredAverage([6, 4, 8, 12, 3]) → 6
    centeredAverage([4, 4, 4, 1, 5]) → 4
     */
    public int centeredAverage(int[] nums) {
        int soma = nums[0];
        int len = nums.length;
        int vMax = nums[0];
        int vMin = nums[0];
        for (int i=1; i<len; i++){
            if (vMax < nums[i]) {
                vMax = nums[i];
            }
            if (vMin > nums[i]) {
                vMin = nums[i];
            }
 
            soma += nums[i];
        }
        return (soma - vMax - vMin) / (len - 2);
        
    }

    /*
    Return the sum of the numbers in the array, 
    returning 0 for an empty array. 
    Except the number 13 is very unlucky, 
    so it does not count and numbers that come immediately after a 13 also do not count.

    sum13([1, 2, 2, 1]) → 6
    sum13([1, 1]) → 2
    sum13([1, 2, 2, 1, 13]) → 6
    */
    public int sum13(int[] nums) {
        int saida = 0;
        int len = nums.length;
        if (len == 0) return 0;
        for (int i=0; i<len; i++){
            if (nums[i] != 13) {
                saida += nums[i];
            }
            else {
                i++;
            }
        }
        return saida;
    }
      
    /*
    Array-2 > sum67
    Return the sum of the numbers in the array, 
    except ignore sections of numbers starting with a 6 
    and extending to the next 7 (every 6 will be followed by at least one 7). 
    Return 0 for no numbers.

    sum67([1, 2, 2]) → 5
    sum67([1, 2, 2, 6, 99, 99, 7]) → 5
    sum67([1, 1, 6, 7, 2]) → 4
    sum67([1, 6, 2, 2, 7, 1, 6, 99, 99, 7]) → 2
    sum67([2, 7, 6, 2, 6, 7, 2, 7]) → 18
    sum67([2, 7, 6, 2, 6, 2, 7]) → 9
    sum67([1, 6, 7, 7]) → 8		
    sum67([6, 7, 1, 6, 7, 7]) → 8	
    sum67([6, 8, 1, 6, 7]) → 0	
    sum67([]) → 0
    sum67([6, 7, 11]) → 11	
    sum67([11, 6, 7, 11]) → 22
    sum67([2, 2, 6, 7, 7]) → 11
     */
    public int sum67(int[] nums) {
        int len = nums.length;
        int soma = 0;
        for (int i=0; i<len; i++){
            if (nums[i] == 6) {
                for (int j=i+1; j<len; j++){
                    if (nums[j]==7) {
                        i = j+1;
                        break;
                    }
                }
            }
            if (i < len) {
                soma += nums[i];
            }
        }
        return soma;    
    }
        
    /*
    Given an array of ints, 
    return true if the array contains a 2 next to a 2 somewhere.

    has22([1, 2, 2]) → true
    has22([1, 2, 1, 2]) → false
    has22([2, 1, 2]) → false
    */ 
    public boolean has22(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len; i++){
          if (i+1 < len && nums[i] == 2 && nums[i+1] == 2) return true;
        }
        return false;
      }
      
    


}
