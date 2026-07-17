class Solution {

    public boolean[][] reachable;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        reachable = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (i == j)  reachable[i][j] = true;
                else reachable[i][j] = false;
            }
        }

        for (int[] prerequisite : prerequisites) {
            reachable[prerequisite[0]][prerequisite[1]] = true;
        }

        floydWarshall();
        List<Boolean> answer = new LinkedList<>();
        for (int[] query : queries) {
            if (reachable[query[0]][query[1]]) answer.add(true);
            else answer.add(false);
        }
        return answer;
    }

    public void floydWarshall() {
        for (int k = 0; k < reachable.length; k++) {
            for (int i = 0; i < reachable.length; i++) {
                for (int j = 0; j < reachable.length; j++) {
                    if (reachable[i][k] && reachable[k][j]) reachable[i][j] = true;
                }
            }
        }
    }
}