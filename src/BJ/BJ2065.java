package BJ;

import java.io.*;
import java.util.*;

class Passenger {
    int arrivalTime;
    int dock;
    int index;

    Passenger(int arrivalTime, int dock, int index) {
        this.arrivalTime = arrivalTime;
        this.dock = dock;
        this.index = index;
    }
}

public class BJ2065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int M = Integer.parseInt(firstLine[0]); // 배에 탈 수 있는 최대 인원 수
        int t = Integer.parseInt(firstLine[1]); // 이동 시간
        int N = Integer.parseInt(firstLine[2]); // 손님의 수

        Queue<Passenger> leftDock = new LinkedList<>();
        Queue<Passenger> rightDock = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int arrivalTime = Integer.parseInt(line[0]);
            int dock = line[1].equals("left") ? 0 : 1;
            if (dock == 0) {
                leftDock.add(new Passenger(arrivalTime, dock, i));
            } else {
                rightDock.add(new Passenger(arrivalTime, dock, i));
            }
        }

        int[] result = new int[N];
        boolean isLeft = true;
        int currentTime = 0;

        while (!leftDock.isEmpty() || !rightDock.isEmpty()) {
            if (isLeft) {
                if (!leftDock.isEmpty() && leftDock.peek().arrivalTime <= currentTime) {
                    int count = 0;
                    while (count < M && !leftDock.isEmpty() && leftDock.peek().arrivalTime <= currentTime) {
                        Passenger p = leftDock.poll();
                        result[p.index] = currentTime + t;
                        count++;
                    }
                    currentTime += t;
                    isLeft = false;
                } else if (!rightDock.isEmpty() && rightDock.peek().arrivalTime <= currentTime) {
                    currentTime += t;
                    isLeft = false;
                } else {
                    int nextTime = Math.min(leftDock.isEmpty() ? Integer.MAX_VALUE : leftDock.peek().arrivalTime,
                            rightDock.isEmpty() ? Integer.MAX_VALUE : rightDock.peek().arrivalTime);
                    currentTime = Math.max(currentTime, nextTime);
                }
            } else {
                if (!rightDock.isEmpty() && rightDock.peek().arrivalTime <= currentTime) {
                    int count = 0;
                    while (count < M && !rightDock.isEmpty() && rightDock.peek().arrivalTime <= currentTime) {
                        Passenger p = rightDock.poll();
                        result[p.index] = currentTime + t;
                        count++;
                    }
                    currentTime += t;
                    isLeft = true;
                } else if (!leftDock.isEmpty() && leftDock.peek().arrivalTime <= currentTime) {
                    currentTime += t;
                    isLeft = true;
                } else {
                    int nextTime = Math.min(leftDock.isEmpty() ? Integer.MAX_VALUE : leftDock.peek().arrivalTime,
                            rightDock.isEmpty() ? Integer.MAX_VALUE : rightDock.peek().arrivalTime);
                    currentTime = Math.max(currentTime, nextTime);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}