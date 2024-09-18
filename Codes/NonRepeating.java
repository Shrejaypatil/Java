

/*Find the First Non-Repeating Character
Given a string, find the first non-repeating character in it.
*/

import java.util.Scanner;

class NonRepeating
{
    public static String str;
    public static char ans;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");

        str = sc.next();

        System.out.println("string Entered: " + str);

        System.out.println("First Non Repeating Character is: " + solve());
    }

    public static char solve()
    {
        char[] arr = str.toCharArray();

        for(int i=0;i<arr.length;i++)
        {
            boolean flag = true;
            for(int j = i + 1; j < arr.length && (arr[i] != '!'); j++)
            {
                if (arr[j] == arr[i])
                {
                    arr[j] = '!';
                    flag = false;
                    break;
                }
            }
            if(flag && arr[i] != '!')
            {
                ans = arr[i];
                return ans;
            }
        }

        return '\0';
    }
}