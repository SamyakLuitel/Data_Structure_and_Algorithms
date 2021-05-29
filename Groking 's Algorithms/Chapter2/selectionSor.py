def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index


def selectionSort(arr):
    newArr = []
    for i in range(len(arr)):
        smallest = findSmallest(arr)
        newArr.append(arr.pop(smallest))
    return newArr


data = [4, 4, 7, 9, 3, 6, 3, 3, 0, 8, 1, 3, 7, 4, 6, 15, 7]
ans = selectionSort(data)

print(data)
print(ans)
