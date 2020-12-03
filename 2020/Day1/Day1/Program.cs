using System;

namespace Day1
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = System.IO.File.ReadAllLines(@"F:\Workspace\AdventOfCode\2020\Day1\Day1\input.txt");
            int[] input = new int[lines.Length];
            for (int i = 0; i < lines.Length; i++)
            {
                input[i] = Convert.ToInt32(lines[i]);
            }
            Console.WriteLine(RunPart1(input));
            Console.WriteLine(RunPart2(input));

        }
        private static int RunPart1(int[] input)
        {
            for (int i = 0; i < input.Length; i++)
            {
                int a = input[i];
                for (int j = i; j < input.Length; j++)
                {
                        if (a + input[j] == 2020)
                        {
                            Console.WriteLine($"{a},{input[j]}");
                            return a * input[j];
                        }
                }
            }
            return 0;
        }
        private static int RunPart2(int[] input)
        {

            for (int i = 0; i < input.Length; i++)
            {
                int a = input[i];
                for (int j = i; j < input.Length; j++)
                {
                    int b = input[j];
                    for (int k = j; k < input.Length; k++)
                    {
                        if (a + b + input[k] == 2020)
                        {
                            Console.WriteLine($"{a},{b}, {input[k]}");
                            return a * b * input[k];
                        }
                    }

                }
            }
            return 0;
        }
    }
}
