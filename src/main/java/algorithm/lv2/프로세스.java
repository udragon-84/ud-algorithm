package algorithm.lv2;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
public class 프로세스 {

    public int solution(int[] priorities, int location) {
        Queue<DocumentPriorities> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new DocumentPriorities(i, priorities[i]));
        }

        int prior = 1;
        while(!queue.isEmpty()) {
            DocumentPriorities currentDoc = queue.poll();
            if (queue.stream().anyMatch(doc -> doc.getPriorities() > currentDoc.getPriorities())) {
                queue.add(currentDoc);
            } else {
                if (currentDoc.getIndex() == location) break;
                prior++;
            }
        }
        return prior;
    }

    public static void main(String[] args) {
        프로세스 main = new 프로세스();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int result = main.solution(priorities, 0);
        System.out.println(result);
    }

    private static class DocumentPriorities {
        private int index;
        private int priorities;

        public DocumentPriorities(int index, int priorities) {
            this.index = index;
            this.priorities = priorities;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public void setPriorities(int priorities) {
            this.priorities = priorities;
        }

        public int getPriorities() {
            return this.priorities;
        }

        @Override
        public String toString() {
            return "DocumentPriorities [index=" + index + ", priorities=" + this.priorities + "]";
        }
    }
}
