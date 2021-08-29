package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {

    /***
     * https://leetcode.com/problems/meeting-rooms/
     *
     */

    public static int canAttendAllMeetings(List<List<Integer>> intervals) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (List<Integer> interval : intervals) {
            startTimes.add(interval.get(0));
            endTimes.add(interval.get(1));
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        for (int i = 1; i < intervals.size(); i++) {
            if (startTimes.get(i) < endTimes.get(i - 1)) return 0;
        }

        return 1;
    }


    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(1, 5));
        intervals.add(Arrays.asList(4, 8));
        //intervals.add(Arrays.asList(5, 8));
        intervals.add(Arrays.asList(10, 15));
        System.out.println("Can attend : " + canAttendAllMeetings(intervals));
    }
}
