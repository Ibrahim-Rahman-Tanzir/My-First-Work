n = int(input())
for _ in range(n):
    s = input()
    length = len(s)
    half = length // 2
    first = s[:half][::-1]
    second = s[half:][::-1]
    print(first + second)
