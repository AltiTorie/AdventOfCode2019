import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuelRequirement
{
    private File f = new File("Input.txt");
    private Scanner scanner;
    int count()
    {
        try
        {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        int sum = 0;
        while (scanner.hasNext())
        {
            int helperSum = scanner.nextInt();
            System.out.println("NEXT: " + helperSum);
            helperSum = (helperSum / 3) - 2;
            sum += helperSum;
            while (helperSum > 0)
            {
                helperSum = (helperSum/ 3) - 2;
                if(helperSum > 0)
                {
                    sum += helperSum;
                }
                System.out.println("HelperSum : " + helperSum);

            }
            System.out.println("Sum: " + sum);

        }
        return sum;
    }
}

class Main
{
    public static void main(String[] args)
    {
        FuelRequirement a = new FuelRequirement();
        System.out.println(a.count());
    }
}
