import java.util.Arrays;

public class MergeIntervals {
    public static void bubblesort(int[][] intervals)
    {
        int n = intervals.length;
        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j< n-i-1; j++)
            {
                if(intervals[j][0] > intervals[j+1][0])
                {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j+1];
                    intervals[j+1]=temp;
                }
            }
        }
    }

    public static int[][] merge(int[][] intervals)
    {
        bubblesort(intervals);

        int index=0;

        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[index][1] >= intervals[i][0])
            {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
            else
            {
                index++;
                intervals[index] = intervals[i];
            }
        }

        int[][]   result = new int[index+1][2];

        for(int i=0; i<=index; i++)
        {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }

        return result;
    }

     public static void main(String[] args)
    {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,19}};
        int[][] result = merge(intervals);

        System.out.println("Merged Intervals");
        for(int[] interval: result)
        {
            System.out.println(Arrays.toString(interval));
        }
    }
}
