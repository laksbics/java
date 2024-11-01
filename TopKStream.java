import java.util.ArrayList;
import java.util.List;

public class TopKStream {

    private int k;
    private List<Integer> stream;

    public TopKStream(int k) {
      this.k = k;
      this.stream = new ArrayList<>();
    }

    public void add(int num)
    {
        int i;

        for(i= stream.size()-1; i >=0 && stream.get(i) < num; i--)
        {
            if(i+1 < stream.size()){
                stream.set(i+1, stream.get(i));
            }
            else {
                stream.add(stream.get(i));
            }
        }

        if(i+1 < stream.size())
        {
            stream.set(i+1, num);
        }
        else {
            stream.add(num);
        }

        if(stream.size() > k)
        {
            stream.remove(stream.size()-1);
        }
    }


    public Integer getTopK(){
        if(stream.size() < k){
            return null;
        }
        return stream.get(k-1);
    }

    public static void main(String[] args)
    {
        int k=3;
        TopKStream streamProcessor = new TopKStream(k);
        int[] numbers = {5,2,9,7,4,8};

        for(int num: numbers)
        {
            streamProcessor.add(num);
            System.out.println("Top " + k + "-th value after adding " + num + ": " + streamProcessor.getTopK());
        }
    }

}