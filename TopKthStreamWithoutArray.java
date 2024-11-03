public class TopKthStreamWithoutArray {
    
   public static int[] topKElements(int[] stream, int k)
   {
        int[] topK = new int[k];
        int count =0;

        for(int num: stream)
        {
            if(count <k)
            {
                topK[count] = num;
                count++;
                sortArray(topK, count);
            }
            else{
                if(num > topK[0])
                {   
                    topK[0] = num;
                    sortArray(topK,k);
                }
            }
        }
        return topK;
   }

   public static void sortArray(int[] arr, int n){
    for(int i=1; i<n; i++)
    {
        int key = arr[i];
        int j = i-1;

        while (j>=0 && arr[j] > key) {
            arr[j+1] = arr[j];
             j= j-1;
        }
        arr[j+1] = key;
    }
   }


   public static void main(String[] args) {
    int[] stream = {10, 5, 11, 3, 20, 18, 15};
    int k = 3;

    int[] result = topKElements(stream, k);

    // Print the top k elements
    for (int i = result.length - 1; i >= 0; i--) {
        System.out.print(result[i] + " ");
    }
}
}
