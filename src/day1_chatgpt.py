import itertools

def main():
    with open("src/day1") as file:
        data = file.read().split("\n")
        # use list comprehension to convert all elements to integers
        data = [int(x) for x in data if x]
        # group the data into chunks of size n
        n = sum(data[:3])
        chunks = [list(g) for k, g in itertools.groupby(data, lambda x: data.index(x)//n)]
        # find the sum of each chunk
        calories = [sum(chunk) for chunk in chunks]

    max_value = max(calories)
    max_index = calories.index(max_value)
    print(max_value, max_index)

    calories.sort()
    print(calories[-3:])
    print(sum(calories[-3:]))

if __name__ == '__main__':
    main()