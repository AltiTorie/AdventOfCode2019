import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ShipComputer
{
    File f = new File("Input.txt");
    Scanner scanner;
    int[] input;

    ShipComputer() throws IOException
    {
        BufferedReader inputReader;
        inputReader = new BufferedReader(new FileReader(f));

        String row;
        row = inputReader.readLine();
        String[] data = row.split(",");

        scanner = new Scanner(System.in);


        input = Arrays.stream(data).mapToInt(Integer::parseInt).toArray();
    }

    int[] simulation()
    {
        opCodeRunning:
        for (int i = 0; i < input.length; )
        {
            int[] operation = getInstruction(input[i]);
            switch (operation[0])
            {
                case 1://input[3] = input[1] + input[2]
                    input[input[i + 3]] = mode(operation[1], i + 1) + mode(operation[2], i + 2);
                    i += 4;
                    break;
                case 2://input[3] = input[1] * input[2]
                    input[input[i + 3]] = mode(operation[1], i + 1) * mode(operation[2], i + 2);
                    i += 4;
                    break;
                case 3://input[2] = scanner
                    System.out.println("Input: ");
                    input[input[i + 1]] = scanner.nextInt();
                    i += 2;
                    break;
                case 4://print(input[1])
                    System.out.println(mode(operation[1], i + 1));
                    i += 2;
                    break;
                case 5:
                    //jump-if-true
                    if(mode(operation[1],i+1) != 0){
                        i = mode(operation[2],i+2);
                    }
                    else{
                        i+=3;
                    }
                    break;
                case 6:
                    //jump-if-false
                    if(mode(operation[1],i+1) == 0){
                        i = mode(operation[2],i+2);
                    }
                    else{
                        i+=3;
                    }
                    break;
                case 7:
                    //less than
                    input[input[i + 3]] = mode(operation[1], i + 1) < mode(operation[2], i + 2) ? 1 : 0;
                    i+=4;
                    break;
                case 8:
                    //equals
                    input[input[i + 3]] = mode(operation[1], i + 1) == mode(operation[2], i + 2) ? 1 : 0;
                    i+=4;
                    break;
                case 99:
                    break opCodeRunning;
                default:
                    throw new UnsupportedOperationException("InstructionUnknown");
            }
        }
        return input;

    }

    private int[] getInstruction(int value)
    {
        String operation = String.valueOf(value);

        while (operation.length() < 5)
        {
            operation = "0" + operation;
        }

        int[] instruction = new int[4];
        String a;
        a = String.valueOf(operation.subSequence(3, 5));
        instruction[0] = Integer.parseInt(a);
        instruction[1] = Integer.parseInt(String.valueOf(operation.charAt(2)));
        instruction[2] = Integer.parseInt(String.valueOf(operation.charAt(1)));
        instruction[3] = Integer.parseInt(String.valueOf(operation.charAt(0)));

        return instruction;
    }

    private int mode(int value, int index)
    {
        switch (value)
        {
            case 0:
                return input[input[index]];
            case 1:
                return input[index];
        }
        return 0;
    }

    public static void main(String[] args)
    {
        try
        {
            ShipComputer computer = new ShipComputer();
            computer.simulation();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("");
    }
}
