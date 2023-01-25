def main():
    calories = []
    tmp = []
    with open("src/day1") as file:
        data = file.readlines()
        for line in data:
            if line == "\n":
                calories.append(sum(tmp))
                tmp = []
            else:
                tmp.append(int(line.replace("\n", "")))


        print(calories)

    max_value = max(calories)
    max_index = calories.index(max_value)
    print(max_value, max_index)

    calories.sort()

    print(sum(calories[-3:]))
    print(f"Solution: {max_value} and {sum(calories[-3:])}")

if __name__ == '__main__':
    main()
