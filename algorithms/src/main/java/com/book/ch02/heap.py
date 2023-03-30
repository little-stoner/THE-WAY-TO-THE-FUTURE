

def sink(pq, k, n):
    while 2 * k <= n:
        j = 2 * k
        if j < n and pq[j-1] < pq[j]:
            j += 1
        if pq[k-1] > pq[j-1]:
            break
        pq[k-1], pq[j-1] = pq[j-1], pq[k-1]
        k = j

def heap(pq):
    n = len(pq)
    k = n / 2
    print("=================== construct ====================")    
    for k in range(int(n/2), 0, -1):
        sink(pq, k, n)
        print(pq)
 
    print("=================== heaptify =====================")
    k = n
    while k > 1:
        pq[1-1], pq[k-1] = pq[k-1], pq[1-1]
        k -= 1
        sink(pq, 1, k)
        print(pq)


if __name__ == '__main__':
    a = ['S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E']
    print("==================================================")
    print(a)
    heap(a)
    
