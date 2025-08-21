import sys

def longest_common_substring(s1, s2):
    n, m = len(s1), len(s2)
    dp = [0] * (m + 1)
    max_len = 0
    for i in range(1, n + 1):
        prev = 0
        for j in range(1, m + 1):
            temp = dp[j]
            if s1[i - 1] == s2[j - 1]:
                dp[j] = prev + 1
                if dp[j] > max_len:
                    max_len = dp[j]
            else:
                dp[j] = 0
            prev = temp
    return max_len

def main():
    data = sys.stdin.read().splitlines()
    index = 0
    results = []
    while index < len(data):
        s1 = data[index].strip()
        index += 1
        s2 = data[index].strip()
        index += 1
        results.append(str(longest_common_substring(s1, s2)))
    print("\n".join(results))

if __name__ == "__main__":
    main()
