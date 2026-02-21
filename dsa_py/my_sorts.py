import random
import pandas as pd
import matplotlib.pyplot as plt

def bubbleSort(arr):
    A = arr.copy()
    n= len(A)
    swaps = 0
    comparisions = 0

    for i in range(n):
        for j in range(0, n-i-1):
            comparisions += 1
            if A[j] > A[j+1]:
                A[j], A[j+1] = A[j+1], A[j]
                swaps += 1

    return swaps, comparisions

def selectionSort(arr):
    A = arr.copy()
    n = len(A)
    swaps = 0
    comparisions = 0

    for i in range(n):
        minIndex = i

        for j in range(i+1, n):
            comparisions += 1
            if A[j] < A[minIndex]:
                minIndex = j

        if minIndex != i:
            A[i], A[minIndex] = A[minIndex], A[i]
            swaps += 1

    return swaps, comparisions

def insertionSort(arr):
    A = arr.copy()
    n = len(A)
    swaps = 0
    comparisions = 0

    for i in range(1, n):
        key = A[i]
        j = i-1

        while j>=0:
            comparisions += 1
            if A[j] > key:
                A[j+1] = A[j]
                swaps += 1
                j -= 1
            else:
                break

        A[j+1] = key

    return swaps, comparisions



n_values = list(range(10,1001,10))
allData = []

print("Running Sorts. Please wait...")

for n in n_values:

    testArray = [random.randint(1,10000) for _ in range(n)]

    bubbleSwap, bubbleComp = bubbleSort(testArray)
    allData.append({"N": n, "Algorithm": "Bubble", "Swaps": bubbleSwap, "Comparisions": bubbleComp})

    selectionSwap, selectionComp = selectionSort(testArray)
    allData.append({"N": n, "Algorithm": "Selection", "Swaps": selectionSwap, "Comparisions": selectionComp})

    insertionSwap, insertionComp = insertionSort(testArray)
    allData.append({"N": n, "Algorithm": "Insertion", "Swaps": insertionSwap, "Comparisions": insertionComp})

df = pd.DataFrame(allData)
df.to_excel("SortingAnalysis.xlsx", index = False)

styles = {"Bubble": "o-", "Selection": "--", "Insertion": ":"}
colors = {"Bubble": "blue", "Selection": "#FF8C00", "Insertion": "#FF0000"}

plt.figure(figsize = (10, 6))
for algo in ["Bubble", "Selection", "Insertion"]:
    subset = df[df["Algorithm"] == algo]
    plt.plot(subset["N"], subset["Comparisions"], styles[algo], color=colors[algo], label = algo, alpha = 0.7, linewidth = 2)

plt.title("Comparisons vs Array Size (N)")
plt.xlabel("N")
plt.ylabel("Comparisons")
plt.legend()
plt.grid(True)
plt.savefig("Comparisons_Plot.png")

plt.figure(figsize = (10, 6))
for algo in ["Bubble", "Selection", "Insertion"]:
    subset = df[df["Algorithm"] == algo]
    plt.plot(subset["N"], subset["Swaps"], styles[algo], color=colors[algo], label=algo, alpha = 0.7, linewidth = 2)

plt.title("Swaps vs Array Size (N)")
plt.xlabel("N")
plt.ylabel("Swaps")
plt.legend()
plt.grid(True)
plt.savefig("Swaps_Plot.png")

print("All done! Check your folder for the Excel and PNG files.")
