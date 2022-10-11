package service;

import javax.xml.validation.Validator;

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
      
    /*  Given an array of ints, return true if it contains no 1's or it contains no 4's.
        no14([1, 2, 3]) → true
        no14([1, 2, 3, 4]) → false
        no14([2, 3, 4]) → true
    */

    public boolean no14(int[] nums) {
  
        boolean c1 = false;
        boolean c4 = false;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 1) c1 = true;
            if (nums[i] == 4) c4 = true;
        }
        if (!c1 || !c4) return true;
        return false;

    }
    /*
        We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, 
        at least one of the pair is that value. 
        Return true if the given value is everywhere in the array.

        isEverywhere([1, 2, 1, 3], 1) → true
        isEverywhere([1, 2, 1, 3], 2) → false
        isEverywhere([1, 2, 1, 3, 4], 1) → false
    */
    public boolean isEverywhere(int[] nums, int val) {
        int len=nums.length;
        if (len<=1) return true;
        
        boolean resp = false;
        for (int i=1; i<nums.length; i++){
            if (nums[i-1]==val || nums[i]==val) {
              resp = true;
            } else {
              return false;
            }
        }
        return resp;

    }

    /*
    Given an array of ints, 
    return true if the array contains a 2 next to a 2 or a 4 next to a 4, 
    but not both.

    either24([1, 2, 2]) → true
    either24([4, 4, 1]) → true
    either24([4, 4, 1, 2, 2]) → false
    */
    public boolean either24(int[] nums) {
        boolean v2 = false;
        boolean v4 = false;
        for (int i=1; i<nums.length; i++){
            if (nums[i-1]==2 && nums[i]==2) v2 = true;
            if (nums[i-1]==4 && nums[i]==4) v4 = true;
        }
        return v2 ^ v4;
    }
    /*
    Given arrays nums1 and nums2 of the same length, 
    for every element in nums1, consider the corresponding element in nums2 (at the same index).
    Return the count of the number of times that the two elements differ by 2 or less, 
    but are not equal.

    matchUp([1, 2, 3], [2, 3, 10]) → 2
    matchUp([1, 2, 3], [2, 3, 5]) → 3
    matchUp([1, 2, 3], [2, 3, 3]) → 2
     */
    public int matchUp(int[] nums1, int[] nums2) {
        int resp = 0;
        int sub;
        for (int i=0; i<nums1.length; i++){
            sub = Math.abs(nums1[i] - nums2[i]);
            if (sub > 0 && sub <= 2){
                resp++;
            }
        }
        return resp;
    }
    /*
    Given an array of ints, return true if the array contains two 7's next to each other, 
    or there are two 7's separated by one element, 
    such as with {7, 1, 7}.

    has77([1, 7, 7]) → true
    has77([1, 7, 1, 7]) → true
    has77([1, 7, 1, 1, 7]) → false
    */
    public boolean has77(int[] nums) {
        if (nums.length<=1) return false;
        for (int i=2; i<nums.length; i++){
            if (nums[i-2]==7 && nums[i-1]==7) return true;
            if (nums[i-2]==7 && nums[i]==7) return true;
            if (nums[i-1]==7 && nums[i]==7) return true;
        }
        return false;
    }
    /*
    Given an array of ints, 
    return true if there is a 1 in the array with a 2 somewhere later in the array.

    has12([1, 3, 2]) → true
    has12([3, 1, 2]) → true
    has12([3, 1, 4, 5, 2]) → true
     */
    public boolean has12(int[] nums) {
        int len = nums.length;
        for (int i=1; i<len; i++){
            if (nums[i-1]==1) {
                for (int j=i; j<len; j++){
                    if(nums[j]==2) return true;
                }
            }
        }   
        return false;
    }
    



}
