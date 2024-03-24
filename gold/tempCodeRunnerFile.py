    while graph[item][2]:
                    target=graph[item][2].pop()
                    prevnum[target]-=1
                    dq.append((target,graph[item][1]))
                        # check.add(target)