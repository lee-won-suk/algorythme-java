package 백준.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 킹1063 {
    public static class Position {
        int currentXposition, currentYposition, stoneXposition, stoneYposition;
        public Position(int currentXposition, int currentYposition,int stoneXposition, int stoneYposition) {
            this.currentXposition = currentXposition;
            this.currentYposition = currentYposition;
            this.stoneXposition = stoneXposition;
            this.stoneYposition = stoneYposition;

        }
        public boolean isSamePosition(int totalXposition,int totalYposition) {
            return totalXposition == stoneXposition &&
                    totalYposition == stoneYposition;
        }
        public void move(String move) {
            int moveXposition = 0;
            int moveYposition = 0;
            int totalXposition = 0;
            int totalYposition = 0;
            int totalStoneXposition = 0;
            int totalStoneYposition = 0;
            if (move.equals("B")) {
                moveYposition = -1;
            }
            if (move.equals("T")) {
                moveYposition = 1;
            }
            if (move.equals("R")) {
                moveXposition = 1;
            }
            if (move.equals("L")) {
                moveXposition = -1;
            }
            if (move.equals("RT")) {
                moveXposition = 1;
                moveYposition = 1;
            }
            if (move.equals("LT")) {
                moveXposition = -1;
                moveYposition = 1;
            }
            if (move.equals("RB")) {
                moveXposition = 1;
                moveYposition = -1;
            }
            if (move.equals("LB")) {
                moveXposition = -1;
                moveYposition = -1;
            }
            totalXposition = this.currentXposition + moveXposition;
            totalYposition = this.currentYposition + moveYposition;
            totalStoneXposition = this.stoneXposition + moveXposition;
            totalStoneYposition = this.stoneYposition + moveYposition;

            if ((totalXposition >= 1 && totalXposition <= 8 && totalYposition >= 1 && totalYposition <= 8 && !isSamePosition(totalXposition,totalYposition))
                ||(isSamePosition(totalXposition,totalYposition)&& totalStoneXposition >= 1 && totalStoneXposition <= 8 &&
                    totalStoneYposition >= 1 && totalStoneYposition <= 8)) {
                this.currentXposition = totalXposition;
                this.currentYposition = totalYposition;
            }
            if (this.isSamePosition(totalXposition,totalYposition) && totalStoneXposition >= 1 && totalStoneXposition <= 8 &&
                    totalStoneYposition >= 1 && totalStoneYposition <= 8) {
                this.stoneXposition = totalStoneXposition;
                this.stoneYposition = totalStoneYposition;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Map<String, Integer> convert = new HashMap<>();
        convert.put("A", 1);
        convert.put("B", 2);
        convert.put("C", 3);
        convert.put("D", 4);
        convert.put("E", 5);
        convert.put("F", 6);
        convert.put("G", 7);
        convert.put("H", 8);

        Map<Integer, String> convertNumber = new HashMap<>();
        convertNumber.put(1, "A");
        convertNumber.put(2, "B");
        convertNumber.put(3, "C");
        convertNumber.put(4, "D");
        convertNumber.put(5, "E");
        convertNumber.put(6, "F");
        convertNumber.put(7, "G");
        convertNumber.put(8, "H");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingFirstPosition = st.nextToken();
        String stoneFirstPosition = st.nextToken();
        int totalMoveCount = Integer.parseInt(st.nextToken());
        String[] kingArr = kingFirstPosition.split("");
        String[] stoneArr = stoneFirstPosition.split("");

        Position position = new Position(convert.get(kingArr[0]), Integer.parseInt(kingArr[1]),
                convert.get(stoneArr[0]), Integer.parseInt(stoneArr[1]));
        for (int i = 0; i < totalMoveCount; i++) {
            String moveOrder = br.readLine();
            position.move(moveOrder);
        }
        String kingTotalPosition = String.valueOf(convertNumber.get(position.currentXposition))
                + String.valueOf(position.currentYposition);
        String stoneTotalPosition = String.valueOf(convertNumber.get(position.stoneXposition))
                + String.valueOf(position.stoneYposition);
        System.out.println(kingTotalPosition);
        System.out.println(stoneTotalPosition);

    }
}
