import sys

for line in sys.stdin:
    line = line.rstrip('\n')
    result = []
    upper = True
    for c in line:
        if c == ' ':
            result.append(c)
        else:
            result.append(c.upper() if upper else c.lower())
            upper = not upper
    print(''.join(result))
