numbers = list(input("Enter a sequence of comma separated values: ").split(","))
print(numbers)
total = 0

for number in numbers:
    total += int(number)

print(total)
