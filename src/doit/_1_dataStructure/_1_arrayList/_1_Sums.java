package doit._1_dataStructure._1_arrayList;


import java.util.Scanner;
/* https://www.acmicpc.net/problem/11720 */
/*
*
* 1. 아이디어
* - 입력
* 1번째 줄 : 숫자의 개수(N), 1<=N<=100
* 2번째 줄 : 숫자 N개가 공백없이 주륵
*
* - 출력
* 2번째 줄의 숫자 N개의 합
*
* 공백이 없는 숫자를 어떻게 한자리 단위로 싹 다 잘라서 그걸 다 더하지?
* 입력받는건 sc.nextInt 는 안돼. N이 21억보다 클수도 있잖아. sc.next을 통해 String으로 받아야겠군
* String 으로 받은 '4201241' 이걸 한자리로 다 잘라야해. 반복문이 쓰여야할 거 같아.
* String 으로 받은 다음에 char[] 로 하나하나 바꿔야하나? ㅇㅇ
* str.toCharArray() 함수 사용해서 바꿔야.
* 바꾸고 반복문으로 하나하나 char 요소를 int 요소로 바꾸며 sum 에 더함
*
*
*
* 새로 배운것 :
* 1. char -> int 변환법 :
    * 1-1. 숫자char - 48
    * 1-2. 숫자char - '0'
    * 1-3. Character.getNumericValue(char)
    * 1-4. Integer.parseInt(String.valueOf(char))
* 2. .toCharArray() : String -> char[] 로 변환하는 메서드.
* 3. 반복문 밖에 데이터 저장할 변수 미리 선언해둬야. 리셋, 누적가능
* 4. nextInt 다음에 next() 쓰는거면 nextLine() 할 필요없는듯
*
*
* */
public class _1_Sums {

    static void 내풀이(Scanner sc) {
        // 입력받기
        int n = sc.nextInt();
        String sNum = sc.next();

        // String 숫자를 char[] 로 변환
        char[] charArray = sNum.toCharArray();

        // char[] 을 int[] 로
        int[] intArr = new int[n];
        for (int i = 0; i < charArray.length; i++) {
//            int num = charArray[i] - 48;  // ASCII 코드 값을 직접 사용한 변환
//            int num = charArray[i] - '0';   //  ASCII 코드를 이용한 변환 (가독성 좋음, 권장)
//            int num = Character.getNumericValue(charArray[i]);    // Character 클래스의 메서드를 사용한 변환
            int num = Integer.parseInt(String.valueOf(charArray[i])); // String.valueOf() 메서드 활용

            intArr[i] = num;
        }


        // int[] 안의 누적합
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }
        System.out.println("sum = " + sum);

        sc.close();
    }

    static void 답풀이(Scanner sc) {
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        내풀이(sc);
        답풀이(sc);

    }
}
