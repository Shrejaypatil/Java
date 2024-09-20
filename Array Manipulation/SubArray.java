
/**
 * Find the subarray with the maximum sum (Kadane's Algorithm)
 *
 *  *Given an array of integers, find the contiguous subarray that has the largest sum.
 */
class SubArray {

    public static void main(String args[]) {
        int arr[] = {1,2,3};

        int maxSum = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0 )
            {
                currSum = 0;
            }
        }

        System.out.println("Maximum sum of subarray is: " + maxSum);


        System.out.println("Finding all subarrays");


        for(int i=0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length ; j++)
            {
                for(int k = i ; k <= j; k++)
                {
                    System.out.print(arr[k] + " ");
                }
            }
            System.out.println();
        }
    }
}
