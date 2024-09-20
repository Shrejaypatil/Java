
/*
Find the missing number in a range

An array contains n distinct numbers in the range [0, n]. One number is missing, find the missing number.
 */
class FindMissing {

    public static void main(String args[]) {

        int n = 9;
        int arr[] = {0, 1, 2, 3, 4, 6, 7, 8, 9};

        int actualSum = n * (n + 1) / 2;

        int sum = 0;

        for (int x : arr) {
            sum += x;
        }

        System.out.println("Missing number is: " + (actualSum - sum));

    }
}
