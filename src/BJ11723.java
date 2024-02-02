import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            switch (operation) {
                case "add":
                    int xAdd = Integer.parseInt(st.nextToken());
                    add(set, xAdd);
                    break;
                case "remove":
                    int xRemove = Integer.parseInt(st.nextToken());
                    remove(set, xRemove);
                    break;
                case "check":
                    int xCheck = Integer.parseInt(st.nextToken());
                    result.append(check(set, xCheck)).append("\n");
                    break;
                case "toggle":
                    int xToggle = Integer.parseInt(st.nextToken());
                    toggle(set, xToggle);
                    break;
                case "all":
                    all(set);
                    break;
                case "empty":
                    empty(set);
                    break;
            }
        }

        System.out.print(result.toString());
    }

    private static void add(Set<Integer> set, int x) {
        set.add(x);
    }

    private static void remove(Set<Integer> set, int x) {
        set.remove(x);
    }

    private static int check(Set<Integer> set, int x) {
        return set.contains(x) ? 1 : 0;
    }

    private static void toggle(Set<Integer> set, int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    private static void all(Set<Integer> set) {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    private static void empty(Set<Integer> set) {
        set.clear();
    }
}
