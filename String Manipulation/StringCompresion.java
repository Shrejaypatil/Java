
/*
String Compression

Implement a method to compress strings by counting consecutive characters. For example, aabcccccaaa becomes a2b1c5a3.

 */
import java.util.Scanner;

class StringCompresion {

    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string :");

        str = sc.next();

        System.out.println("Compressed String is : " + solve());

    }

    public static String solve() {
        String result = "";
        int count = 1;

        for(int i = 1 ; i < str.length() ; i++)
        {
            if(str.charAt(i-1) == str.charAt(i))
            {
                count ++;
            }
            else
            {
                result += str.charAt(i-1);
                result += count;
                count = 1;
            }
        }


        result += str.charAt(str.length()-1);
        result += count;

        return result;

    }
}
