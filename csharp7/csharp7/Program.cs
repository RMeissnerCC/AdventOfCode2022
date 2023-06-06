using day1;

new Day1().Main();

namespace day1
{
    public class Day1
    {
        public List<int> Calories(List<string> list)
        {
            var ints = new List<int>();
            var tmp = new List<int>();

            foreach (var line in list)
            {
                switch (line)
                {
                    case "\n":
                    case "":
                        ints.Add(tmp.Sum());
                        tmp = new List<int>();
                        break;
                    default:
                        tmp.Add(int.Parse(line.Replace("\n", "")));
                        break;
                }
            }

            return ints;
        }

        public void Main()
        {
            const string fileName = "../../../../../src/main/resources/aoc2022/day1";
            var lines = File.ReadLines(fileName).ToList();
            Console.WriteLine(lines);
            var calories = Calories(lines);

            calories.Sort();
            Console.WriteLine(calories);
            Console.WriteLine(calories.Max());
            Console.WriteLine(calories.GetRange(calories.Count - 3, 3).Sum());
        }
    }
}