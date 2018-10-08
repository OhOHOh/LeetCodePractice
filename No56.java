import java.util.*;

public class No56 {

    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        // lambal 表达式
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));

        return result;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start-o2.start;
                }
                return (o1.end-o2.end);
            }
        });
        ListIterator<Interval> it = intervals.listIterator();
        Interval cur = it.next();
        while (it.hasNext()) {
            Interval next = it.next();
            if (cur.end < next.start) {
                cur = next;
            } else {
                cur.end = Math.max(cur.end, next.end);
                it.remove();
            }
        }

        return intervals;
    }

    private Interval mergeTo(Interval a, Interval b) {
        if (a.end <= b.start) {
            return new Interval(a.start, b.end);
        } else {
            return new Interval(b.start, a.end);
        }
    }
}
