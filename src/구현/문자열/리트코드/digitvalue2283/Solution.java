package 구현.문자열.리트코드.digitvalue2283;

public class Solution {

    public boolean digitCount(String num) {
        for (int numIndex = 0; numIndex < num.length(); numIndex++) {

            int finalNumIndex = numIndex;
            int number = (int) num.chars().map(Character::getNumericValue).filter(a -> a == finalNumIndex).count();
            if (number != Integer.parseInt(String.valueOf(num.charAt(finalNumIndex)))) {
                return false;
            }
        }
        return true;
    }
}
