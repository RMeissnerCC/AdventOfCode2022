def read_data(filepath):
    with open(filepath) as file:
        # use list comprehension to convert all elements to integers and remove empty lines
        data = [int(line.strip()) for line in file if line.strip()]
    return data

def main():
    with open("src/day1") as file:
        calories = [sum(map(int, chunk.split())) for chunk in file.read().split("\n\n") if chunk]
    # find the sum of each chunk

    max_value = max(calories)
    max_index = calories.index(max_value)
    calories.sort()
    solution = sum(calories[-3:])
    print(f"Max value: {max_value}")
    print(f"Solution: {solution}")

if __name__ == '__main__':
    main()
