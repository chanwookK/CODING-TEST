class Solution {
    public int[][] merge(int[][] intervals) {
        List<Time> timesList = new ArrayList<>();
        Deque<Time> times = new ArrayDeque<>();
        Deque<Time> results = new ArrayDeque<>();

        for (int[] interval : intervals) {
            timesList.add(new Time(interval[0], interval[1]));
        }

        timesList.sort((a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });

        for (Time t : timesList) {
            times.offer(t);
        }

        while (!times.isEmpty()) {
            Time first = times.poll();

            if (times.isEmpty()) {
                results.offer(first);
                break;
            }

            Time second = times.poll();
            Time merged = merge(first, second);

            if (merged != null) {
                times.push(merged);
            }
            else {
                results.offer(first);
                times.push(second);
            }
        }

        int[][] resultArray = new int[results.size()][2];
        int i = 0;
        while (!results.isEmpty()) {
            Time current = results.poll();
            resultArray[i][0] = current.start;
            resultArray[i++][1] = current.end;
        }

        return resultArray;
    }

    public Time merge(Time first, Time second) {
        if (first.end >= second.start) {
            if (first.end <= second.end) {
                return new Time(first.start, second.end);
            }
            else {
                return new Time(first.start, first.end);
            }
        }
        
        return null;
    }
}

public class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}