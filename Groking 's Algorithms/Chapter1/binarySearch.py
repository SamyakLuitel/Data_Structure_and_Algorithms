def binary_search(arr, item):
    '''This function returns position of item in the list if found'''
    low = 0
    high = len(arr)-1

    while low <= high:
        mid = (low+high)//2
        guess = arr[mid]
        if guess == item:
            return mid
        if guess < item:
            low = mid
        else:
            high = mid
    return None


l = [i*3 for i in range(10000)]
ans = binary_search(l, 300)
print(ans)
