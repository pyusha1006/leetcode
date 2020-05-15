/**
Leetcode Question 454
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
**/

// Time Complexity : O(n^2)
// Space Complexity : O(n)
/** The solution considers 2 arrays at a time and finds all possible sum from the two arrays and stores the same in a map where
* sum is stored in key and value stores the frequency of occurence of that sum.Next, we take other two arrays and for all
* possible sums in those two arrays we check if the map contains a compliment key of the sum,if yes, we increase the count.
**/
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 && B.length == 0 && C.length == 0 && D.length == 0)
            return 0;
        
        int count = 0;
        Map<Integer,Integer> sumAndOcurrences = new HashMap<>();
        for(int aIndex = 0;aIndex<A.length;aIndex++){
           for(int bIndex = 0;bIndex<B.length;bIndex++){
               int sum = A[aIndex]+B[bIndex];
               //creating a map to set the sum and frequency
                sumAndOcurrences.put(sum,sumAndOcurrences.getOrDefault(sum,0)+1);
            }
        }
        
        for(int cIndex = 0;cIndex<C.length;cIndex++){
           for(int dIndex = 0;dIndex<D.length;dIndex++){
               // suming the elements of rest two arrays and checking if the complement of that exists in the 
               //hashmap created above.
                count += sumAndOcurrences.getOrDefault(-1 * (C[cIndex]+D[dIndex]),0);
            }
        }
        return count;
    }
}
