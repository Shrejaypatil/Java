



/*
Find the maximum and minimum elements in an array

Given an array of integers, find the maximum and minimum elements.
 */

class MinMax
{
    public static void main(String args[])
    {
        int[] arr = {4,52,1,60,58,0,2,-5,100};

        int max = arr[0];
        int min = arr[0];


        for(int x : arr)
        {
            if(x > max)
            {
                max = x;
            }
            if(x < min) 
            {
                min = x;
            }
        }

        System.out.println("The max element :" + max + " The min element : " + min);
    }
}