

import java.util.Scanner;

class RemoveDuplicate
{
    public static String str;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string :");

        str = sc.nextLine();

        System.out.println("New String :  " + solve());
    }

    public static String solve()
    {
        String result = "";

        String temp = str.toLowerCase();

        for(int i=0; i < temp.length(); i++)
        {
            if(!result.contains(String.valueOf(temp.charAt(i))))
            {
                result += temp.charAt(i);
            }
        }

        return result;
    }
}