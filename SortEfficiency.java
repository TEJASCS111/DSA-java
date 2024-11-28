import java.util.Arrays;

public class SortEfficiency {
    void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) heapify(arr, arr.length, i);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) swap(arr, ++i, j);
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SortEfficiency se = new SortEfficiency();
        int[] arr1 = {10, 7, 8, 9, 1, 5}, arr2 = arr1.clone();
        
        long start = System.nanoTime();
        se.heapSort(arr1);
        long heapTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        se.quickSort(arr2, 0, arr2.length - 1);
        long quickTime = System.nanoTime() - start;

        System.out.println("Heap Sort: " + Arrays.toString(arr1) + ", Time: " + heapTime + " ns");
        System.out.println("Quick Sort: " + Arrays.toString(arr2) + ", Time: " + quickTime + " ns");
    }
}
