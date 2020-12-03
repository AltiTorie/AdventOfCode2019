import javax.xml.xpath.XPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Distance
{
    File f = new File("Input.txt");
    Scanner scanner;


    int simulation() throws IOException
    {
        //Read info
        BufferedReader csvReader;
        csvReader = new BufferedReader(new FileReader(f));
        String row;
        row = csvReader.readLine();
        //Create 1st set of arrays with Direction and Distance
        String[] data = row.split(",");
        char[] dirOne = new char[data.length];
        int[] distOne = new int[data.length];
        int sumOne = 0;
        for (int i = 0; i < data.length; i++)
        {
            dirOne[i] = data[i].charAt(0);
            distOne[i] = Integer.parseInt(data[i].replace(dirOne[i], '0'));
            sumOne += distOne[i];

        }
        //Create 2nd set of arrays with Direction and Distance
        row = csvReader.readLine();
        data = row.split(",");
        char[] dirTwo = new char[data.length];
        int[] distTwo = new int[data.length];
        int sumTwo = 0;
        for (int i = 0; i < data.length; i++)
        {
            dirTwo[i] = data[i].charAt(0);
            distTwo[i] = Integer.parseInt(data[i].replace(dirTwo[i], '0'));
            sumTwo += distTwo[i];

        }

        //Creating a "map" for visualisation of movement
        ArrayList<Coordinates> mapOne = new ArrayList<>();
        int Xpointer = 0;
        int Ypointer = 0;
        int dirIndX;
        int dirIndY;
        int counter = 0;
        int max = 0;
//      path of the first cable
        for (int i = 0; i < dirOne.length; i++)
        {
//      System.out.println("______________" + i + "____________");
            dirIndX = 0;
            dirIndY = 0;
            switch (dirOne[i])
            {
                case 'R':
                {
                    dirIndX = 1;
                    break;
                }
                case 'L':
                {
                    dirIndX = -1;
                    break;
                }
                case 'U':
                {
                    dirIndY = -1;
                    break;
                }
                case 'D':
                {
                    dirIndY = 1;
                    break;
                }
            }

            int d = distOne[i];
            for (int j = 0; j < d; j++)
            {
                Xpointer += dirIndX;
                Ypointer += dirIndY;
                counter++;
                mapOne.add(new Coordinates(Xpointer, Ypointer, counter));
            }
        }

        System.out.println("path of the 2nd cable");
        //path of the 2nd cable

        ArrayList<Coordinates> mapTwo = new ArrayList<>();
        ArrayList<Stepper> cross = new ArrayList<>();
        Xpointer = 0;
        Ypointer = 0;
        counter = 0;
//        System.out.println("X: " + Xpointer + " Y: " + Ypointer);
        for (int i = 0; i < dirTwo.length; i++)
        {
            dirIndX = 0;
            dirIndY = 0;
//            System.out.println("***______________" + i + "____________***");
            switch (dirTwo[i])
            {
                case 'R':
                {
                    dirIndX = 1;
                    break;
                }
                case 'L':
                {
                    dirIndX = -1;
                    break;
                }
                case 'U':
                {
                    dirIndY = -1;
                    break;
                }
                case 'D':
                {
                    dirIndY = 1;
                    break;
                }
            }
            int d = distTwo[i];
            for (int j = 0; j < d; j++)
            {
//                System.out.println("dirX:" + dirIndX + " dirY:" + dirIndY + " d:" + d + " X:" + Xpointer + " Y:" + Ypointer);
                Xpointer += dirIndX;
                Ypointer += dirIndY;
                counter++;
                Coordinates c = new Coordinates(Xpointer, Ypointer, counter);
                mapTwo.add(c);
                if (mapOne.contains(c))
                {
                    cross.add(new Stepper(Xpointer, Ypointer,mapOne.get(mapOne.indexOf(c)).Val() ,counter));
                }

            }
        }

        System.out.println(cross.size());
        System.out.println(cross);
        int num = cross.get(0).getFirstLength() + cross.get(0).getSecondLength();
        int temp;
        for (Stepper s: cross)
        {
            temp = s.getFirstLength() + s.getSecondLength();
            if(num > temp)
            {
                num = temp;
            }
        }

        return num;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Distance DIS = new Distance();
        try
        {
            System.out.println("Outcome:" + DIS.simulation());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}