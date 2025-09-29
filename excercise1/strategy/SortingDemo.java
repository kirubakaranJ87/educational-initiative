package strategy;

import java.util.Arrays;

interface SortStrategy {
    void sort(int[] data);
}

class AscendingSort implements SortStrategy {
    public void sort(int[] data) { Arrays.sort(data); }
}

class DescendingSort implements SortStrategy {
    public void sort(int[] data) {
        Arrays.sort(data);
        for (int i=0; i<data.length/2; i++) {
            int temp = data[i];
            data[i] = data[data.length-1-i];
            data[data.length-1-i] = temp;
        }
    }
}

class DataProcessor {
    private SortStrategy strategy;
    public DataProcessor(SortStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
    public void process(int[] data) {
        System.out.println("Before: " + Arrays.toString(data));
        strategy.sort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}

public class SortingDemo {
    public static void main(String[] args) {
        int[] data = {5,2,9,1,5,6};
        DataProcessor p = new DataProcessor(new AscendingSort());
        p.process(data.clone());
        p.setStrategy(new DescendingSort());
        p.process(data.clone());
    }
}
