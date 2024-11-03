
//  Java Program for Maximum Subarray Sum using Kadane's Algorithm

public class MaxSubArray {

    // static int MaxSubArray(int[] arr)
    // {
    //     int res = arr[0];
    //     int maxEnding = arr[0];
         
    //     for(int i=1; i<arr.length; i++)
    //     {
    //         maxEnding = Math.max(maxEnding + arr[i], arr[i]);

    //         res = Math.max(res, maxEnding);
    //     }

    //     return res;
    // }


    static int MaxSubArray(int[] arr)
    {
        int res = arr[0];
        int maxEnding = arr[0];
        String seq = Integer.toString(arr[0]) + "-->";

        for(int i=1; i<arr.length; i++)
        {
            if(maxEnding + arr[i] > arr[i])
            {
                maxEnding = maxEnding + arr[i] ;
                seq += Integer.toString(arr[i]) + "-->";
            }
            else
            {
                maxEnding =  arr[i];
                seq = Integer.toString(arr[i]) + "-->";
            }

            res = Math.max(res, maxEnding);
        }

        System.out.println(seq);
        return res;
    }


    public static void main(String[] args)
    {
        int[] arr = {2,3,-8,7,-1,2,3};
        System.out.println(MaxSubArray(arr));
    }
    
}
