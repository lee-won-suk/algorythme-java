package 백준.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 올림픽8979 {
    public static class Nation {
        int nationNumber;//국가번호
        int gold;
        int silver;
        int bronze;//금은동 합친값
        int nationScore = 0;//등수

        public Nation(int nationNumber, int gold, int silver, int bronze) {
            this.nationNumber = nationNumber;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        public boolean compare(Nation nation) {
            if (this.gold > nation.gold) {
                return true;//true면 안바꿈
            }
            if (this.silver > nation.silver) {
                return true;
            }
            if (this.bronze > nation.bronze) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nationCount = Integer.parseInt(st.nextToken());
        int targetNationNumber = Integer.parseInt(st.nextToken());
        Nation[] Arr = new Nation[nationCount];
        long start = System.currentTimeMillis();
        int currentNationScore = 1;
        int nationScoreStack = 1; //공동 등수 계산할 값
        for (int i = 0; i < nationCount; i++) {
            st = new StringTokenizer(br.readLine());
            int currentNationNumber = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            Arr[i] = new Nation(currentNationNumber, gold, silver, bronze);
        }
        Arr = Arrays.stream(Arr).sorted((a, b) ->{
            if(a.gold!=b.gold) return b.gold - a.gold;
            if(a.silver!=b.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        } ).toArray(Nation[]::new);// 내림차순 정렬


        for (int j = 0; j < Arr.length; j++) {
            if (j == 0) {
                Arr[j].nationScore = 1;
                if (Arr[j].nationNumber == targetNationNumber) {
                    System.out.println(Arr[j].nationScore);
                    break;
                }
                continue;
            }

            if (Arr[j-1].compare(Arr[j])) {
                currentNationScore += nationScoreStack;
                Arr[j].nationScore = currentNationScore;
                nationScoreStack = 1;
            }

            if (!Arr[j-1].compare(Arr[j])) {//등수가 같을 경우
                Arr[j].nationScore = currentNationScore;
                nationScoreStack += 1;
            }
            if (Arr[j].nationNumber == targetNationNumber) {
                System.out.println(Arr[j].nationScore);
                long end = System.currentTimeMillis();
                break;
            }
        }
    }
}