def quicksort(input, l, r):
    if l < r:
        mid = partition(input, l, r)
        quicksort(input, l, mid-1)
        quicksort(input, mid+1, r)
    
    
def partition(data, l, r):
    viot = data[l]
    while l < r:
        while l<r and data[r]>=viot:
            r--
        data[l] = data[r]
        while l<r and data[l]<=viot:
            l++
        data[r] = data[l]
    data[l] = viot
    return l