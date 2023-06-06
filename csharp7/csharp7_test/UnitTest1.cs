using day1;

namespace csharp7_test;

public class UnitTest1
{
    [Fact]
    public void simpleData()
    {
        var calories = new List<string>
        {
            "10",
            "30",
            "50",
            "",
            "3"
        };
        var program = new Day1();
        var ints = program.Calories(calories);
        Assert.Equal(90, ints.Max());
    }
    [Fact]
    public void rawData()
    {
        
        const string fileName = "../../../../../src/main/resources/aoc2022/day1";
        var calories = File.ReadLines(fileName).ToList();
        var program = new Day1();
        var ints = program.Calories(calories);
        Assert.Equal(66616, ints.Max());
    }
}