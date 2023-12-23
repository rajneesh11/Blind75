public class MergeSort {
    static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge1(a, low, mid, high);
        }
    }

    static void merge1(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[low + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[mid + i + 1];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    static void merge(int[] a, int low, int mid, int high) {
        int h = low, i = low, j = mid + 1, k;
        int[] b = new int[a.length];
        while ((h <= mid) && (j <= high)) {
            if (a[h] <= a[j]) {
                b[i] = a[h];
                h++;
            } else {
                b[i] = a[j];
                j++;
            }
            i++;
        }
        if (h > mid) {
            for (k = j; k <= high; k++) {
                b[i] = a[k];
                i++;
            }
        } else {
            for (k = h; k <= mid; k++) {
                b[i] = a[k];
                i++;
            }

        }
        for (k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, 3, 2, 7, 88, 1 };
        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
