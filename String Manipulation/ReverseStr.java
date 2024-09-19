
import java.util.Scanner;

/*
Reverse a String
Given a string, return the reversed version of it.

*/

class ReverseStr
{

    public static String str;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");

        str = sc.next();

        System.out.println("string Entered: " + str);

        showReverse();

    }

    public static void showReverse()
    {
        // optimised approach
        
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while(i < j)
        {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        System.out.println("Reversed string : " + new String(arr));

    }
}