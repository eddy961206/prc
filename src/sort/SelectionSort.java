package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {5, 1, 6, 4, 2, 3};

        // 정렬 안된 구간에서 현재 위치(정렬 안된 구간의 시작점)와 가장 작은 애의 위치를 바꾸는 반복문
        for (int i = 0; i < arr.length - 1; i++) {

            int minIdx = i; // 정렬 안된 구간에서 현재 인덱스를 가장 작은 애라고 가정하고 출발
            // 자기네들끼리 가장 작은 애의 위치 찾기 위해 비교하는 반복문
            for (int j = i; j < arr.length; j++) {

                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }

            }

            // 정렬 안된 구간에서 현재 위치 애 <=> 내부 반복에서 찾은 가장 작은 애
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            System.out.printf("\n%d 번째 반복 :\n", i + 1);
            System.out.println(Arrays.toString(arr));

        }


    }
}
