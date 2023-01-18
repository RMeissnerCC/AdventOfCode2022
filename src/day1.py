def main():
    calories = []
    tmp = []
    with open("day1") as file:
        data = file.readlines()

        print(len(data))
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

    print(calories)
    print(calories[-3:])
    print(sum(calories[-3:]))

if __name__ == '__main__':
    main()
