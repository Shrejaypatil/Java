
import java.util.Scanner;

class RotateArray
{
    public static void main(String args[])
    {
        int arr[] = {1,2,3,4,5,6,7,8,9};

        System.out.println("Enter number of rotation: ");

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int n = arr.length;

        int temp[] = new int[n];

        for(int i=0; i < n ;i++)
        {
            temp[(i+k)%n] = arr[i];
        }

        System.out.println("Rotated array : ");

        for(int x : temp)
        {
            System.out.print(x + " ");
        }
    }
}