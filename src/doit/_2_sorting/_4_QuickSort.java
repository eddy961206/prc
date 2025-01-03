package doit._2_sorting;


/*
 * 퀵소트 기본 구현
 *
 * https://www.youtube.com/watch?v=7BDzle2n47c&ab_channel=%EC%97%94%EC%A7%80%EB%8B%88%EC%96%B4%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD
 * https://www.youtube.com/watch?v=a3xZAVAPA-s
 *
 *  | 비교 항목        | 첫번째 영상                       | 두번째 영상                          |
 *  |-----------------|-------------------------------|----------------------------------|
 *  | **피벗 선택**    | 중간 값                          | 끝 값 (맨 오른쪽)                |
 *  | **파티션 결과**  | 피벗 값은 이동하지 않음            | 피벗 값이 제 위치로 이동          |
 *  | **반환값**       | 오른쪽 파티션의 시작점            | 피벗 값의 최종 위치              |
 *  | **구현 난이도**  | 상대적으로 직관적임               | 더 일반적이고 단순함              |
 *  | **효율성**       | 입력 데이터에 따라 더 균형적일 가능성 있음 | 단순하지만, 이미 정렬된 입력에선 비효율적일 수 있음 |
 */
public class _4_QuickSort {

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    
    private static class 첫번째영상_정답 {
        static void quickSort(int[] arr) {
            quickSort(arr,0,arr.length - 1);
        }
    
        static void quickSort(int[] arr, int start, int end) {
            int part2 = partition(arr, start, end);
            if (start < part2 - 1) {
                quickSort(arr, start, part2 - 1);
            }
            if (part2 < end) {
                quickSort(arr, part2, end);
            }
        }
    
        static int partition(int[] arr, int start, int end) {
            int pivot = arr[(start + end) / 2];
            while (start <= end) {
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    swap(arr, start, end);
                    start++;
                    end--;
                }
            }
            return start;
        }
    

    }

    private static class 첫번째영상_복습1 {
        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        static void quickSort(int[] arr, int start, int end) {
            // 피벗 기준으로 좌/우 파티션 나누고 새로운 start(part2start), 즉 오른쪽 파티션의 시작점을 가져옴
            int part2start = partition(arr, start, end); // 새로운 피벗이자 원래 피벗 기준 오른쪽 파티션의 시작점

            // 왼쪽 파티션 정렬
    //        if (start < part2 - 1) { // 왜 start < part2 가 아니고 -1 이 더 붙어? -> 왼쪽 파티션이 방이 1개 있으면 왼쪽 파티션을 정렬할 필요 없기 때문
            if (part2start - start > 1) {   // 왼쪽 파티션에 퀵소트 할 게 있을 때 (방이 2개 이상일 때)
                quickSort(arr, start, part2start - 1); // 왼쪽 파티션 퀵소트
            }
            // 오른쪽 파티션 정렬
            if (part2start < end) { // 왜 등호 안들어가? -> 등호 들어가면 오른쪽 파티션을 정렬할 필요가 없기 때문
                quickSort(arr, part2start, end); // 오른쪽 파티션 퀵소트
            }
        }

        static int partition(int[] arr, int start, int end) {
            // 피벗 설정 (여기선 가운데 순서 값)
            int pivot = arr[(start + end) / 2];
            while (start <= end) {  // 등호는 왜 꼭 들어가야만 하나?
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;

                    start++;
                    end--;
                }
            }
            return start;
        }
    }

    private static class 첫번째영상_복습2 {

        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        static void quickSort(int[] arr, int start, int end) {
            // 1. 두 개의 파티션 만들고 그 기준점 리턴받음 (받은 start, end 를 가지고)
            int part2Start = partition(arr, start, end);
            // 2. 왼쪽 파티션 퀵정렬 (재귀)
            if (start + 1 < part2Start) {
                quickSort(arr, start, part2Start - 1);
            }
            // 3. 오른쪽 파티션 퀵정렬 (재귀)
            // else if 로 하면 안됨. 왼쪽&오른쪽 둘 다 정렬해야하는데 else if 로 하면 둘 중 하나만 하니까.
            if (part2Start < end) {
                quickSort(arr, part2Start, end);
            }
        }

        private static int partition(int[] arr, int start, int end) {
            // 1. 피벗(기준) 지정
            int pivot = arr[(start + end) / 2];
            // 2. start가 피벗보다 작은건 무시, end가 피벗보다 큰건 무시 반복 - start 와 end 가 순서가 바뀔때까지
            while (start <= end) {
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    // start 자리와 end 자리 숫자 교환
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    // 교환 후 start, end 하나씩 좁혀
                    start++;
                    end--;
                }
            }
            return start;
        }
    }

    private static class 첫번째영상_복습3 {

        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        static void quickSort(int[] arr, int start, int end) {
            int part2Start = partition(arr, start, end);
            if (start + 1 < part2Start) {
                quickSort(arr, start, part2Start - 1);
            }
            if (part2Start < end) {
                quickSort(arr, part2Start, end);
            }
        }

        static int partition(int[] arr, int start, int end) {
            int pivot = arr[(start + end) / 2];
            while (start <= end) { // start 와 end 가 완전히 역전됐을 때 끝남 -> 이해 아직..
                                    // start 랑 end 가 같으면 넘어가긴 해야하는데..
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }
            return start;
        }
    }

    private static class 첫번째영상_복습4 {
        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        static void quickSort(int[] arr, int start, int end) {
            int part2Start = partition(arr, start, end);
            if (start + 1 < part2Start) {
                quickSort(arr, start, part2Start - 1);
            }
            if (part2Start < end) {
                quickSort(arr, part2Start, end);
            }
        }

        static int partition(int[] arr, int start, int end) {
            int pivot = arr[(start + end) / 2];
            while (start <= end) {
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    swap(arr, start, end);
                    start++;
                    end--;
                }
            }
            return start;
        }
    }

    /*************  아래   두번째 영상      *************/

    private static class 두번째영상_정답 {
        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        static void quickSort(int[] arr, int start, int end) {
            if (start < end) {
                int pivotIdx = partition(arr, start, end);
                quickSort(arr, start, pivotIdx - 1);
                quickSort(arr, pivotIdx + 1, end);
            }
        }

        static int partition(int[] arr, int start, int end) {
            int pivot = arr[end];
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, end);
            return i + 1;
        }
    }


    public static void main(String[] args) {
        int[] arr2 = {3, 9, 4, 7, 0, 1, 5, 8, 6, 2};
        printArray(arr2);
        첫번째영상_복습4.quickSort(arr2);
        printArray(arr2);
    }
}
