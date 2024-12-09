package sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {5, 1, 6, 4, 2, 3};

        boolean sorted = false;
        for (int i = 0; i < arr.length - 1 && !sorted; i++) {

            sorted = true;

            for (int j = 0; j < arr.length - 1 - i; j++) { // 이미 정렬된 뒷 부분은 제외
                // 왼쪽과 오른쪽 비교. 왼쪽이 더 크면 스왑
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    sorted = false;
                }
            }
            System.out.printf("\n%d 번째 반복 :\n", i + 1);
            System.out.println(Arrays.toString(arr));
        }






    }
}
