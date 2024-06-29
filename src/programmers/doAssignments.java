package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class doAssignments {
    // Task 클래스를 정의하여 작업의 이름, 시작 시간, 지속 시간을 저장
    static class Task {
        String name;
        int start;
        int duration;

        // Task 클래스의 생성자
        Task(String name, int start, int duration) {
            this.name = name;
            this.start = start;
            this.duration = duration;
        }
    }

    // 주어진 작업 계획을 처리하여 작업이 완료된 순서를 반환
    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();

        // 주어진 plans 배열을 Task 객체로 변환하여 리스트에 추가
        for (String[] plan : plans) {
            String name = plan[0];
            int start = convertTimeToMinutes(plan[1]);
            int duration = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, duration));
        }

        // 시작 시간에 따라 작업들을 정렬
        tasks.sort(Comparator.comparingInt(task -> task.start));

        List<String> completedTasks = new ArrayList<>();
        Stack<Task> pausedTasks = new Stack<>();
        int currentTime = 0;

        // 작업을 순차적으로 처리
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);

            // 중단된 작업을 재개할 수 있는지 확인
            while (!pausedTasks.isEmpty() && currentTime + pausedTasks.peek().duration <= currentTask.start) {
                Task pausedTask = pausedTasks.pop();
                currentTime += pausedTask.duration;
                completedTasks.add(pausedTask.name);
            }

            // 현재 작업의 시작 시간으로 현재 시간 업데이트
            if (currentTime < currentTask.start) {
                currentTime = currentTask.start;
            }

            // 다음 작업이 있는지 확인하고 처리
            if (i + 1 < tasks.size()) {
                Task nextTask = tasks.get(i + 1);
                // 현재 작업을 완료할 수 있는 경우
                if (currentTask.start + currentTask.duration <= nextTask.start) {
                    completedTasks.add(currentTask.name);
                    currentTime = currentTask.start + currentTask.duration;
                } else {
                    // 현재 작업을 중단해야 하는 경우
                    currentTask.duration -= (nextTask.start - currentTask.start);
                    pausedTasks.push(currentTask);
                    currentTime = nextTask.start;
                }
            } else {
                // 마지막 작업인 경우
                completedTasks.add(currentTask.name);
                currentTime = currentTask.start + currentTask.duration;
            }
        }

        // 모든 중단된 작업을 재개하여 완료
        while (!pausedTasks.isEmpty()) {
            completedTasks.add(pausedTasks.pop().name);
        }

        return completedTasks.toArray(new String[0]);
    }

    // 시간을 "hh:mm" 형식에서 분으로 변환하는 헬퍼 메서드
    private int convertTimeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 사용자 입력을 받아서 solution 메서드를 호출하고 결과를 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("계획 수는? : ");
        int numPlans = Integer.parseInt(br.readLine());

        String[][] plans = new String[numPlans][3];

        for (int i = 0; i < numPlans; i++) {
            System.out.print("Enter plan : " + (i + 1) + " (작업명 시작시간 걸리는 시간): ");
            plans[i] = br.readLine().split(" ");
        }

        doAssignments sol = new doAssignments();
        String[] result = sol.solution(plans);

        System.out.println("완료된 작업 : " + Arrays.toString(result));
    }
}