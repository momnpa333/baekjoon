N = int(input())
word = input()

def make_fellin(s1, s2):
    s1 = " " + s1
    s2 = " " + s2
    prev = [0] * len(s2)
    curr = [0] * len(s2)

    for i in range(1, len(s1)):
        for j in range(1, len(s2)):
            if s1[i] == s2[j]:
                curr[j] = prev[j - 1] + 1
            else:
                curr[j] = max(curr[j - 1], prev[j])
        prev, curr = curr, [0] * len(s2)

    return len(s1) - 1 - prev[len(s2) - 1]

print(make_fellin(word, word[::-1]))
