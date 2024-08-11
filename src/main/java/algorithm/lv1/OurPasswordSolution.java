package algorithm.lv1;

public class OurPasswordSolution {

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char letter: s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char)(temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }
        return answer.toString();
    }



    public static void main(String[] args) {
        OurPasswordSolution ourPasswordSolution = new OurPasswordSolution();
        String s = "aukks";
        String skip = "wbqd";
        int index = 10;
        System.out.println("s=" + s + ", skip=" + skip + ", index=" + index);
        String changePassword = ourPasswordSolution.solution(s, skip, index);
        System.out.println("changePassword: " + changePassword);
    }
}
