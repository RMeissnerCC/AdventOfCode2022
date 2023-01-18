def is_contained(line: str) -> bool:
    pairs = line.replace("\n", "").split(",")
    pairs = [pair.split("-") for pair in pairs]

    first_pair = (int(pairs[0][0]), int(pairs[0][1]) + 1)
    second_pair = (int(pairs[1][0]), int(pairs[1][1]) + 1)

    first_group = range(*first_pair)
    second_group = range(*second_pair)

    result = list(filter(lambda x: x in first_group, second_group))

    return len(result) > 0

    contained = len(result) == len(first_group) or len(result) == len(second_group)
    print(pairs, "Intersection : ", result, contained)
    return contained


def main():
    with open("day4") as file:
        data = file.readlines()

        print(len(data))
        print(data)
        result = sum(map(is_contained, data))
        print("Sum:", result)


if __name__ == '__main__':
    main()
