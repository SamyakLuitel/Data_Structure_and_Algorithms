def binary_search(arr, item, low, high):

    if high >= low:
        mid = (high+low)//2

        if arr[mid] == item:
            return mid

        elif arr[mid] > item:
            return binary_search(arr, item, low, mid-1)
        else:
            return binary_search(arr, item, mid+1, high)

    else:
        return None


l = [i*3 for i in range(10000)]
ans = binary_search(l, 300)
print(ans)
