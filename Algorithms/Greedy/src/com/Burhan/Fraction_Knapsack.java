import java.util.Arrays;
import java.util.Comparator;

public class Fraction_Knapsack {

    static class MyKnap {
        int weight;
        int value;

        MyKnap(int w, int v) {
            weight = w;
            value = v;
        }
    }

    public static void main(String[] args) {
        MyKnap[] arr = {
            new MyKnap(20, 500),
            new MyKnap(30, 400),
            new MyKnap(50, 600)
        };

        int kCap = 70;
        int ans = fractionKnapsack(arr, kCap);
        System.out.println(ans);
    }

    static int fractionKnapsack(MyKnap[] arr, int kCap) {
        int res = 0;
        int currCap = kCap;
        int i = 0;

        Arrays.sort(arr, new Comparator<MyKnap>() {
            @Override
            public int compare(MyKnap a1, MyKnap a2) {
                return (a2.value*a1.weight) -  (a1.value*a2.weight);
            }
        });

        while (i < arr.length && currCap != 0) {
            if (arr[i].weight <= currCap) {
                currCap -= arr[i].weight;
                res += arr[i].value;
            }
            else {
                double ans = (double) (currCap)/ (double)(arr[i].weight);
                int rValue = (int) (arr[i].value * ans);
                res = res + rValue;
            }
            i++;
        }

        return res;
    }
}