for v in dijkstra(graph, start,V):
    if v==int(1e9):
        print('INF')
    else:
        print(v)