
import java.util.Arrays;
import java.util.Scanner;

/*
Check for Anagram

Write a function to determine if two strings are anagrams of each other.
 */


class Anagrams 
{
    public static String s1;
    public static String s2;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string :");

        s1 = sc.next();

        System.out.println("Enter Second string :");

        s2 = sc.next();


        if(solve())
        {
            System.out.println("Strings are Anagram");
        }
        else
        {
            System.out.println("Strings are not Anagram");
        }

    }


    public static boolean solve()
    {
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }
}