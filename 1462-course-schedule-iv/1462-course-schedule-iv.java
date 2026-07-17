class Solution {

    public int[][] distance;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        distance = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (i == j)  distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] prerequisite : prerequisites) {
            distance[prerequisite[0]][prerequisite[1]] = 1;
        }

        floydWarshall();
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            if (distance[query[0]][query[1]] != Integer.MAX_VALUE) answer.add(true);
            else answer.add(false);
        }
        return answer;
    }

    public void floydWarshall() {
        for (int k = 0; k < distance.length; k++) {
            for (int i = 0; i < distance.length; i++) {
                for (int j = 0; j < distance.length; j++) {
                    if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}