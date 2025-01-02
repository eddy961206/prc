package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 4, 2, 3};
//        myInsertion(arr);
        insertion(arr);
    }

    public static void myInsertion(int[] arr) {
        // 1번 인덱스에서부터 오른쪽으로 한칸씩 옮겨가며 총 n-1 번 비교 시작하는 큰 반복문
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    // 왼쪽이 더 크면 왼쪽과 자리교체
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
                System.out.println(Arrays.toString(arr));
            }

        }
    }

    public static void insertion(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];

            int j = i;
            while (j >= 1 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;

            System.out.println(Arrays.toString(arr));

        }
    }

}
