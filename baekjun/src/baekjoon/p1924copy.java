package baekjoon;

import java.io.*;

public class p1924copy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);

        int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayArr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int total = 0;
        for (int i = 0; i < month; i++) {
            total = total + monthArr[i];
        }

        total = total + day;

        System.out.println(dayArr[total % 7]);
    }
}