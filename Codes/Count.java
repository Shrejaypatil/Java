
/* 
Count Vowels and Consonants
Write a function that counts the number of vowels and consonants in a string.
*/
import java.util.Scanner;

class Count
{
    public static String str;
    public static int countVowels = 0;
    public static int countConsonants = 0;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");

        str = sc.next();

        System.out.println("string Entered: " + str);

        solve();
    }

    public static void solve()
    {
        char[] arr = {'a','e','i','o','u'};

        char[] strr = str.toCharArray();

        

        for(char ch1 : strr)
        {
            boolean flag = false;
            for(char ch2 : arr)
            {
                if(ch2 == ch1)
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                countVowels++;
            }
            else
            {
                countConsonants++;
            }
        }

        System.out.println("Total Vowels are: " + countVowels);
        System.out.println("Total Consonants are: " + countConsonants);
    }
}