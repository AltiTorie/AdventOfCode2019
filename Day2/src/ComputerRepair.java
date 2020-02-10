import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
import sun.awt.windows.WPrinterJob;
import sun.security.jgss.GSSCaller;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ComputerRepair
{
    File f = new File("Input.txt");
    Scanner scanner;


    int[] simulation(int noun,int verb) throws IOException
    {
        BufferedReader csvReader;

        csvReader = new BufferedReader(new FileReader(f));
        String row;
        row = csvReader.readLine();
        String[] data = row.split(",");


        int[] input = new int[data.length];
        for (int i = 0; i < data.length; i++)
        {
            input[i] = Integer.parseInt(data[i]);
        }

        input[1] = noun;
        input[2] = verb;
        for (int i = 0; i < input.length; i += 4)
        {
            if (input[i] == 1)
            {
                input[input[i + 3]] = input[input[i + 1]] + input[input[i + 2]];
            } else if (input[i] == 2)
            {
                input[input[i + 3]] = input[input[i + 1]] * input[input[i + 2]];
            } else if (input[i] == 99)
            {
                break;
            } else throw new UnsupportedOperationException();
        }
        csvReader.close();
        return input;

    }

}

class Main
{
    public static void main(String[] args)
    {
        int outcome = 19690720;
        int[] array = new int[0];
        ComputerRepair CR = new ComputerRepair();
        try
        {
            for(int i = 0;i<100;i++){
                for (int j = 0;j< 100;j++){
                    array = CR.simulation(i,j);
                    if(array[0] == outcome){
                        System.out.println("Noun :" + array[1] +", Verb: " + array[2] );
                        System.out.println((100*array[1]) + array[2]);

                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}