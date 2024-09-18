
import java.util.Scanner;

/*
Check for Palindrome
Determine if a given string is a palindrome (reads the same forwards and backwards).
 */

class Palindrome
{

    public static String str;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");

        str = sc.next();

        System.out.println("string Entered: " + str);

        if(isPalindrome())
        {
            System.out.println("Yes it is Palindrome");
        }
        else
        {
            System.out.println("No it is not a  Palindrome");
        }

    }

    public static boolean isPalindrome()
    {
        // optimised approach
        
        int i = 0;
        int j = str.length() - 1;

        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;

    }
}