import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = reader.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);

        Set<String> notHeardOfSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            notHeardOfSet.add(reader.readLine().trim());
        }

        Set<String> allPeopleSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String name = reader.readLine().trim();
            allPeopleSet.add(name);
        }

        Set<String> unheardSet = new TreeSet<>(notHeardOfSet);
        unheardSet.retainAll(allPeopleSet);

        System.out.println(unheardSet.size());
        for (String unheardName : unheardSet) {
            System.out.println(unheardName);
        }
    }
}
