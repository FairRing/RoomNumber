import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
/*
# Room Number

- 출처 : https://www.acmicpc.net/problem/1475

## 문제
다솜이는 은진이의 옆집에 새로 이사왔다. 
다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 
한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

## 입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

## 출력
첫째 줄에 필요한 세트의 개수를 출력한다.

## 예제 
입력 : 9999
출력 : 2
*/

        Scanner scanner = new Scanner(System.in);       // 방번호 입력
        int roomNumber = -1;         // 방번호
        int[] carryCountRoomNumber = new int[10];       //방번호 초기화 시, 0~9까지 카운드용 배열
        int[] array_roomNumber;
        int set = 0;

        // 첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
        while (true) {
            roomNumber = scanner.nextInt();
            if ((-1 < roomNumber) && (roomNumber < 1000001)) {
                array_roomNumber = convertIntToIntarray(roomNumber);
                break;
            }
        }

        for (int i = 0; i < array_roomNumber.length; i++) {

            for (int j = 0; j < 10; j++) {// 각 0~9까지 카운팅
                if (array_roomNumber[i] == 9) {
                    if (array_roomNumber[i] == j) {
                        carryCountRoomNumber[j - 3] = carryCountRoomNumber[j - 3] + 1;
                    }
                } else {
                    if (array_roomNumber[i] == j) {
                        carryCountRoomNumber[j] = carryCountRoomNumber[j] + 1;
                    }
                }
            }
        }

        carryCountRoomNumber[6] = (int)carryCountRoomNumber[6]/2+(int)carryCountRoomNumber[6]%2;
        Arrays.sort(carryCountRoomNumber);




        set = (int)carryCountRoomNumber[carryCountRoomNumber.length-1];


        // test
        // System.out.println("roomNumssber :: " + roomNumber);
        // System.out.println("Set :: " + carryCountRoomNumber[carryCountRoomNumber.length-1]);
        System.out.println(Integer.toString(set));

        scanner.close();

    }

    static int[] convertIntToIntarray(int n) {
        int j = 0;
        int len = Integer.toString(n).length();
        int[] arr = new int[len];
        while (n != 0) {
            arr[len - j - 1] = n % 10;
            n = n / 10;
            j++;
        }
        return arr;
    }

}
