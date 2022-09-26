import java.util.Arrays;
import java.util.Comparator;

public class Activity_Solution_Problem {

    static class Activity {
        int start;
        int finish;

        Activity(int s, int f) {
            start = s;
            finish = f;
        }
    }

    public static void main(String[] args) {
        Activity[] arr = {
                new Activity(1, 3),
                new Activity(2, 4),
                new Activity(3, 8),
                new Activity(10, 11)
        };

        int ans = activitySolution(arr);
        System.out.println(ans);
    }

    static int activitySolution(Activity[] arr) {
        int res = 1;
        int i = 1;

        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity s1, Activity s2) {
                return s1.finish - s2.finish;
            }
        });

        while (i < arr.length) {
            if (arr[i - 1].finish >= arr[i].start) {
                res++;
            }
            i++;
        }

        return res;
    }

}