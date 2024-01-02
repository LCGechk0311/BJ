import java.util.*;
class Member implements Comparable<Member> {
    int age;
    String name;
    int order;

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    @Override
    public int compareTo(Member other) {
        if (this.age == other.age) {
            return Integer.compare(this.order, other.order);
        }
        return Integer.compare(this.age, other.age);
    }
}

public class BJ10814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();
            members.add(new Member(age, name, i + 1));
        }

        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}
