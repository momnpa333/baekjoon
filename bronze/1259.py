while True:
    n = input()
    if not int(n):
        break
    print("yes" if n== n[::-1]else "no")