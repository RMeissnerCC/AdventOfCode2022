def make_crate_order(crate_order_definition: list[str]) -> list[str]:
    print(len(crate_order_definition))
    for line in crate_order_definition:
        print("---", line, len(line))
        for space in range(0, len(line) // 3):
            print(space, crate_order_definition[space * 3:(space + 1) * 3])


def main():
    with open("day5") as file:
        data = file.readlines()

        print(len(data))

        crate_order_definition: list[str] = []
        tasks: list[str] = []

        for line in data:
            line = line.replace("\n", "")
            if "move" in line:
                tasks.append(line)
            elif "[" in line:
                crate_order_definition.append(line)

        print(crate_order_definition)

        crate_order = make_crate_order(crate_order_definition)
        print(tasks)


if __name__ == '__main__':
    main()
