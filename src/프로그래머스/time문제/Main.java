package 프로그래머스.time문제;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String video_len = "25:00";
        String pos = "00:00";
        String op_start = "00:10";
        String op_end = "00:30";
        String[] commands = {"next"};
        String result = solution.solution(video_len, pos, op_start, op_end, commands);
        System.out.println(result); // Expected output: "00:10"
    }
    }
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("mm:ss");
        LocalTime nowPos = LocalTime.parse(pos, df);
        LocalTime zero = LocalTime.parse("00:00", df);
        LocalTime opStart = LocalTime.parse(op_start, df);
        LocalTime opEnd = LocalTime.parse(op_end, df);

        LocalTime ten = LocalTime.parse("00:10", df);
        LocalTime end = LocalTime.parse(video_len, df);
        LocalTime endBeforeTen = end.minusNanos(10L);

        for (int i = 0; i < commands.length; i++) {
            //오프닝 건너뛰기 실행
            if (nowPos.equals(opStart) || nowPos.equals(opEnd) ||
                    (nowPos.isAfter(opStart) && nowPos.isBefore(opEnd))) {
                nowPos = LocalTime.parse(op_end, df);
            }


            if (commands[i].equals("prev")) {
                //10초보다 작으면 최초로
                if (nowPos.isBefore(ten)) {
                    nowPos = zero;
                }
                nowPos = nowPos.minusSeconds(10L);
            } else if (commands[i].equals("next")) {
                if (nowPos.isAfter(endBeforeTen)) {
                    nowPos = end;
                }
                nowPos = nowPos.plusSeconds(10L);
            }
        }
        return nowPos.format(df);

    }
}
