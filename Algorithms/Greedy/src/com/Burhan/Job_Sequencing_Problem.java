import java.util.Arrays;
import java.util.Comparator;

public class Job_Sequencing_Problem {
    
    static class MyJobs {
        int deadline;
        int profit;
        char id;

        MyJobs(char i, int d, int p) {
            deadline = d;
            profit = p;
            id = i;
        }
    }
    
    public static void main(String[] args) {
        MyJobs[] arr = {
            new MyJobs('a', 2, 100),
            new MyJobs('b', 1, 50),
            new MyJobs('c', 2, 10),
            new MyJobs('d', 1, 20),
            new MyJobs('e', 3, 30)
        };

        int t = 3;

        int ans = jobSequence(arr, t);
        System.out.println(ans);

        jobSeq(arr, t);
    }

    // This gives the total Maximum profit he can make by doing 't' no. of Jobs. If id not present
    static int jobSequence(MyJobs[] arr, int t) {
        int res = 0;
        int i = 1;

        Arrays.sort(arr, new Comparator<MyJobs>() {
            @Override
            public int compare(MyJobs a1, MyJobs a2) {
                return a2.profit - a1.profit;
            }
        });

        res += arr[0].profit;
        t -= 1;

        while (t != 0 && i < arr.length) {
            res += arr[i].profit;
            t--;
            i++;
        }

        return res;
    }

    // If id present
    static void jobSeq(MyJobs[] arr, int t) {

        boolean[] result = new boolean[t];
        char[] jobs = new char[t];

        Arrays.sort(arr, new Comparator<MyJobs>() {
            @Override
            public int compare(MyJobs j1, MyJobs j2) {
                return j2.profit - j1.profit;
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            for (int j = Math.min(t-1, arr[i].deadline-1); j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    jobs[j] = arr[i].id;
                    break;
                }
            }
        }

        System.out.print(Arrays.toString(jobs));
    }

}
