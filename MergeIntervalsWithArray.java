import java.util.Arrays;

public class MergeIntervalsWithArray {
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int index = 0;

        for (int i =1; i< intervals.length; i++)
        {
            if(intervals[index][1] > intervals[i][0])
            {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
            else
            {
                index++;
                intervals[index] = intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals, 0, index+1);
    }

    public static void main(String[] args)
    {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        System.out.println("Merged Intervals");
        for(int[] interval: result)
        {
            System.out.println(Arrays.toString(interval));
        }
    }
}
