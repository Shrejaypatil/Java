
import java.util.HashSet;
import java.util.Set;

class RemoveDuplicates
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,3,3,3,4,50,50,50,50,60};

        Set<Integer> s = new HashSet<>();

        for (int x : arr)
        {
            s.add(x);
        }
        for (int x : s)
        {
            System.out.print(x + " ") ;
        }
    }
}