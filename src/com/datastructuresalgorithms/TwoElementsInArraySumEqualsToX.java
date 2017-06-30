package com.datastructuresalgorithms;

import java.util.Arrays;

public class TwoElementsInArraySumEqualsToX {
	public boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
        int l, r;
       
        /* Sort the elements */
        Arrays.sort(A);
       
        /* Now look for the two candidates 
           in the sorted array*/
        l = 0;
        r = arr_size-1; 
        while (l < r)
        {
             if(A[l] + A[r] == sum)
                  return true; 
             else if(A[l] + A[r] < sum)
                  l++;
             else // A[i] + A[j] > sum
                  r--;
        }    
        return false;
    }
}
