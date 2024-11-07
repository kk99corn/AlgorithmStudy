import java.util.*;

public class Template {

    public int solution(String str, char t) {
        return 0;
    }
    
    public static void main(String[] args) {
        Template t = new Template();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        sc.close();

        int answer = t.solution(str, c);
        System.out.println(answer);
    }
}
