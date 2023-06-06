using System.Collections.Generic;
using System.IO;
using System.Linq;

void Main()
    {
        const string fileName = "../../../../src/main/resources/aoc2022/day1";
        var lines = File.ReadLines(fileName).ToList();
        System.Console.WriteLine(lines);
        var calories = new List<int>();
        var tmp = new List<int>();

        foreach (var line in lines)
        {
            System.Console.WriteLine(line);
            if (line == "\n" || line == string.Empty)
            {
                calories.Add(tmp.Sum());
                tmp = new List<int>();
            }
            else
            {
                tmp.Add(int.Parse(line.Replace("\n", "")));
            }
        }

        calories.Sort();
        System.Console.WriteLine(calories);
        System.Console.WriteLine(calories.Max());
        System.Console.WriteLine(calories.GetRange(calories.Count - 3, 3).Sum());
    }