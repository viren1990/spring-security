package io.viren.interviews;


import java.util.ArrayList;
import java.util.List;

public class Election {
    /**
     * A group of students are sitting in a circle. The teacher is electing a new class president.
     * The teacher does this by singing a song while walking around the circle. After the song is
     * finished the student at which the teacher stopped is removed from the circle.
     * <p>
     * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
     * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
     * <p>
     * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
     * <p>
     * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
     * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
     *
     * @param n the number of students sitting in a circle.
     * @param k the length (in students) of each song.
     * @return the number of the student that is elected.
     */
    public static int whoIsElected(int n, int k) {
        if (n == 1)
            return 1;
        else
            return (whoIsElected(n - 1, k) + k - 1) % n + 1;
    }

    public static int whoIsElectedNonRecursive(int n, int k) {
        int killingiId = 0;
        final List<Integer> students = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            students.add(i);
        }
        int counter = 0;
        while (students.size() > 1) {
            killingiId = (killingiId + k - 1) % students.size();
            students.remove(killingiId);

            System.out.println("Round number is " + ++counter);
            System.out.println("Survivors left is ");
            students.stream().forEach(System.out::println);
        }
        System.out.println();
        return students.get(0);
    }

    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}
        int[][] testCases = {
                // {1, 1, 1},
                // {2, 2, 1},
                {5, 2, 3},
                //{100, 2, 73},
                //{5, 3, 4},
                //{6, 4, 5},
                //{1000, 5, 763}
        };

        for (int[] testCase : testCases) {
            int answer = whoIsElectedNonRecursive(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    /**
     * Execution entry point.
     */
    public static void main(String args[]) {
        doTestsPass();
    }
}
