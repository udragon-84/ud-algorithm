package algorithm.lv0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackerTest {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String lineString = null;
        while(!"eof".equalsIgnoreCase(lineString) && scanner.hasNext()) {
            lineString = scanner.nextLine();
            if (!"eof".equalsIgnoreCase(lineString)) {
                stringList.add(lineString);
            }
        }

        int listSize = stringList.size();
        for (int i = 0; i < listSize; i++) {
            int lineNumber = i + 1;
            System.out.println(lineNumber + " " + stringList.get(i));
        }
    }
}
