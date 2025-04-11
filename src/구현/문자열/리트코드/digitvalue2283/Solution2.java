package 구현.문자열.리트코드.digitvalue2283;

public class Solution2 {

    public boolean digitCount(String num) {
        //1. 미리 배열 개수를 정해놓는다.
        var arr = new int[10];
        for (char i : num.toCharArray()) {
            arr[i - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            //i번째 인덱스의 값인 등장횟수와 i 번쨰 문자열의 숫자를 비교한다.
            if (arr[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
