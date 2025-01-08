package doit._2_sorting;


/*
 * 머지소트 기본 구현
 *
 * https://www.youtube.com/watch?v=QAyl79dCO_k
 *
 */
public class _5_MergeSort {

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    private static class 답풀이 {

        private static void mergeSort(int[] arr) {
            int[] tmp = new int[arr.length];
            mergeSort(arr, tmp, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
            if (start < end) {  //  분할은 크기가 1보다 큰 경우에만
                int mid = (start + end) / 2;
                mergeSort(arr, tmp, start, mid);
                mergeSort(arr, tmp, mid + 1, end);
                merge(arr, tmp, start, mid, end);
            }
        }

        private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
            for (int i = start; i <= end; i++) {
                tmp[i] = arr[i];
            }
            int part1 = start;
            int part2 = mid + 1;
            int index = start;
            while (part1 <= mid && part2 <= end) {
                if (tmp[part1] <= tmp[part2]) {
                    arr[index] = tmp[part1];
                    part1++;
                } else {
                    arr[index] = tmp[part2];
                    part2++;
                }
                index++;
            }
            // 오른쪽 배열이 먼저 끝나서 남은 왼쪽 배열의 데이터 삽입
            for (int i = part1; i <= mid; i++) {
                arr[index++] = tmp[i];
            }
        }


        private static void main() {
            int[] arr2 = {4, 2, 3, 1};
            printArray(arr2);
            mergeSort(arr2);
            printArray(arr2);
        }
    }

    private static class 복습1 {
        private static void mergeSort(int[] arr) {
            int[] tmp = new int[arr.length];
            mergeSort(arr, tmp, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(arr, tmp, start, mid);
                mergeSort(arr, tmp, mid + 1, end);
                merge(arr, tmp, start, mid, end);
            }
        }

        private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
            for (int i = start; i <= end; i++) {
                tmp[i] = arr[i];
            }
            int part1 = start;
            int part2 = mid + 1;
            int index = start;
            while (part1 <= mid && part2 <= end) {
                if (tmp[part1] <= tmp[part2]) {
                    arr[index++] = tmp[part1++];
                } else {
                    arr[index++] = tmp[part2++];
                }
            }

            // 왼쪽이 먼저 끝나면 오른쪽 거 남아도 그냥 놔둬도 돼
            // 오른쪽이 먼저 끝났을 때
            for (int i = part1; i <= mid; i++) {
                arr[index++] = tmp[i];
            }
        }


        private static void main() {
            int[] arr = {4, 2 ,3 ,1};
            mergeSort(arr);
            printArray(arr);
        }
    }
    private static class 복습2 {
        static void mergeSort(int[] arr) {
            int[] tmp = new int[arr.length];
            mergeSort(arr, tmp, 0, arr.length - 1);
        }

        static void mergeSort(int[] arr, int[] tmp, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                // 왼쪽 절반 mergeSort (start ~ mid)
                mergeSort(arr, tmp, start, mid);
                // 오른쪽 절반 mergeSort (mid + 1 ~ end)
                mergeSort(arr, tmp, mid + 1, end);
                // 합병
                merge(arr, tmp, start, mid, end);
            }
        }

        static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
            for (int i = start; i <= end; i++) {
                tmp[i] = arr[i];
            }
            int part1 = start;
            int part2 = mid + 1;
            int index = start;

            while (part1 <= mid && part2 <= end) {  // 틀림..
                if (tmp[part1] <= tmp[part2]) {
                    arr[index++] = tmp[part1++];
                } else {
                    arr[index++] = tmp[part2++];
                }
            }
            // 오른쪽이 먼저 소진돼면 왼쪽거 제자리에 정렬해야 (반대 경우는 안해도 됨)
            for (int i = part1; i <= mid; i++) {
                arr[index++] = tmp[i];
            }
        }

        static void main() {
            int[] arr = {4, 2, 3, 1};
            mergeSort(arr);
            printArray(arr);
        }
    }
    private static class 복습3 {

        static void mergeSort(int[] arr) {
            int[] tmp = new int[arr.length];
            mergeSort(arr, tmp, 0, arr.length - 1);
        }

        static void mergeSort(int[] arr, int[] tmp, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(arr, tmp, start, mid);
                mergeSort(arr, tmp, mid + 1, end);
                merge(arr, tmp, start, mid, end);
            }
        }

        static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
            for (int i = start; i <= end; i++) {
                tmp[i] = arr[i];
            }
            int part1 = start;
            int part2 = mid + 1;
            int index = start;
            while (part1 <= mid && part2 <= end) {
                if (tmp[part1] <= tmp[part2]) {
                    arr[index++] = tmp[part1++];
                } else {
                    arr[index++] = tmp[part2++];
                }
            }
            for (int i = part1; i <= mid; i++) {
                arr[index++] = tmp[i];
            }
        }

        static void main() {
            int[] arr = {4, 23, 21, 89};
            mergeSort(arr);
            printArray(arr);
        }
    }


    public static void main(String[] args) {
//        답풀이.main();
        복습3.main();
    }

}
