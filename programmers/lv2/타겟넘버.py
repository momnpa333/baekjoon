numbers=[1,1,1,1,1]
target=3
def solution(numbers, target):
    n=len(numbers)
    count=0
    def dfs(depth, sum):
        if depth==n:
            if sum==target:
                nonlocal count
                count+=1
            return
        else:
            dfs(depth+1, sum+numbers[depth])
            dfs(depth+1, sum-numbers[depth])
    dfs(0,0)
    return count
print(solution(numbers, target))