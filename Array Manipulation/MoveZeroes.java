
/*
Move all zeros to the end

Given an array of integers, move all the zeros to the end while maintaining the order of the other elements.
 */


class MoveZeroes {

    public static void main(String args[]) {
        int[] arr = {0, 1, 2, 0, 500, 2, 3, 0, 1, 0, 0, 20, 7, 0, 0, 45};

        int i = 0;
        int j = arr.length - 1;

        while(i < j)
        {
            if(arr[i] == 0 && arr[j] != 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
            else if(arr[i] != 0 && arr[j] != 0)
            {
                i++;
            }
            else if(arr[i] == 0 && arr[j] == 0)
            {
                j--;
            }
            else 
            {
                i++;
                j--;
            }
        }

        System.out.println("Modified array :");
        for(int x : arr)
        {
            System.out.print(x + " ");
        }

    }
}
