

/*
Implement strstr()
Find the index of the first occurrence of a substring within another string, or return -1 if not found.
 */
import java.util.Scanner;


class Strstr
{
    public static String s1;
    public static String s2;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string: ");

        s1 = sc.next();

        System.out.println("string Entered: " + s1);

        System.out.println("Enter Second string: ");

        s2 = sc.next();

        System.out.println("string Entered: " + s2);

        System.out.println("Sub String present at index: " + solve());
    }


    public static int solve()
    {
        if(s2.length() > s1.length())
        {
            return -1;
        }

        int n = s1.length() - 1;
        int indexS1 = 0;
        int indexS2 = 0;
        int ans = 0;
        boolean visited = true;

        while(n >= 0 && indexS2 < s2.length())
        {
            if(s1.charAt(indexS1) == s2.charAt(indexS2))
            {
                System.out.println("inside when index 1 is " + indexS1);
                if(visited)
                {
                    ans  = indexS1;
                    visited = false;
                }
                
                indexS2 ++ ;
        
                indexS1 ++ ;
            }
            else
            {
                indexS1 ++ ;
            }
            n--;
        }

        if(indexS2 == s2.length())
        {
            return ans;
        }
        else
        {
            return -1;
        }
    }
}