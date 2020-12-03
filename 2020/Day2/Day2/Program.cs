using System;
using System.Linq;

namespace Day2
{
    class Program
    {
        static string EX1_PATH = "example1.txt";
        static string EX2_PATH = "example2.txt";
        static string INPUT_PATH = "input.txt";
        static void Main(string[] args)
        {
            string[] ex_lines = System.IO.File.ReadAllLines(INPUT_PATH);
            Console.WriteLine(runPart1(ex_lines));
            Console.WriteLine(runPart2(ex_lines));

        }

        static int runPart1(string[] lines)
        {
            int counter = 0;
            for (int i = 0; i < lines.Length; i++)
            {
                (int low, int up, char cond, string pass) = splitInput(lines[i]);
                int count = pass.Count(c => c == cond);
                if (low <= count && count <= up)
                {
                    counter++;
                }
            }
            return counter;
        }

        static int runPart2(string[] lines)
        {
            int counter = 0;
            for (int i = 0; i < lines.Length; i++)
            {
                (int first, int second, char cond, string pass) = splitInput(lines[i]);
                if (pass[first - 1] == cond ^ pass[second - 1] == cond)
                {
                    counter++;
                }
            }
            return counter;
        }

        static (int, int, char, string) splitInput(string line)
        {
            string[] splitted = line.Split(' ');
            string[] lims = splitted[0].Split('-');
            (int low, int up) = (Convert.ToInt32(lims[0]), Convert.ToInt32(lims[1]));
            char c = splitted[1][0];
            string pass = splitted[2];
            return (low, up, c, pass);
        }
    }
}
