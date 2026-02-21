import random
import pandas as pd
import matplotlib.pyplot as plt

# Sorting Algorithms

def bubbleSort(arr):
    A = arr.copy()
    n = len(A)
    swaps = 0
    comparisons = 0

    # Compare adjacent elements and bubble the largest to the end
    for i in range(n):
        for j in range(0, n-i-1):
            comparisons += 1
            if A[j] > A[j+1]:
                A[j], A[j+1] = A[j+1], A[j]
                swaps += 1

    return swaps, comparisons

def selectionSort(arr):
    A = arr.copy()
    n = len(A)
    swaps = 0
    comparisons = 0

    # Find the minimum element in the unsorted portion and swap it to the front
    for i in range(n):
        minIndex = i

        for j in range(i+1, n):
            comparisons += 1
            if A[j] < A[minIndex]:
                minIndex = j

        # Only swap if a new minimum is found
        if minIndex != i:
            A[i], A[minIndex] = A[minIndex], A[i]
            swaps += 1

    return swaps, comparisons

def insertionSort(arr):
    A = arr.copy()
    n = len(A)
    swaps = 0
    comparisons = 0

    # Build the sorted array one element at a time by shifting larger elements to the right
    for i in range(1, n):
        key = A[i]
        j = i-1

        while j>=0:
            comparisons += 1
            if A[j] > key:
                A[j+1] = A[j]
                swaps += 1
                j -= 1
            else:
                break # Early exit if the correct spot is found

        A[j+1] = key

    return swaps, comparisons


# Main logic xD

# Test array sizes from 10 to 1000 in steps of 10
n_values = list(range(10, 1001, 10))
allData = []

print("Running Sorts. Please wait...")

for n in n_values:
    # Generate a new random array for this N
    testArray = [random.randint(1, 10000) for _ in range(n)]

    # Run and log all three algorithms on the exact same array
    bubbleSwap, bubbleComp = bubbleSort(testArray)
    allData.append({"N": n, "Algorithm": "Bubble", "Swaps": bubbleSwap, "Comparisons": bubbleComp})

    selectionSwap, selectionComp = selectionSort(testArray)
    allData.append({"N": n, "Algorithm": "Selection", "Swaps": selectionSwap, "Comparisions": selectionComp})

    insertionSwap, insertionComp = insertionSort(testArray)
    allData.append({"N": n, "Algorithm": "Insertion", "Swaps": insertionSwap, "Comparisions": insertionComp})

# Export and Plotting 

# Export to Excel
df = pd.DataFrame(allData)
df.to_excel("SortingAnalysis.xlsx", index=False)

# Set custom styles to make overlapping lines visible
styles = {"Bubble": "o-", "Selection": "--", "Insertion": ":"}
colors = {"Bubble": "blue", "Selection": "#FF8C00", "Insertion": "#FF0000"}

# Plot 1: Comparisons
plt.figure(figsize=(10, 6))
for algo in ["Bubble", "Selection", "Insertion"]:
    subset = df[df["Algorithm"] == algo]
    plt.plot(subset["N"], subset["Comparisons"], styles[algo], color=colors[algo], label=algo, alpha=0.7, linewidth=2)

plt.title("Comparisons vs Array Size (N)")
plt.xlabel("N")
plt.ylabel("Comparisons")
plt.legend()
plt.grid(True)
plt.savefig("Comparisons_Plot.png")

# Plot 2: Swaps
plt.figure(figsize=(10, 6))
for algo in ["Bubble", "Selection", "Insertion"]:
    subset = df[df["Algorithm"] == algo]
    plt.plot(subset["N"], subset["Swaps"], styles[algo], color=colors[algo], label=algo, alpha=0.7, linewidth=2)

plt.title("Swaps vs Array Size (N)")
plt.xlabel("N")
plt.ylabel("Swaps")
plt.legend()
plt.grid(True)
plt.savefig("Swaps_Plot.png")

print("All done! Check your folder for the Excel and PNG files.")
