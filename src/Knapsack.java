import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of items with values and weights, as well as a max weight, find the
 * maximum value you can generate from items where the sum of the weights is less than
 * the max.
 * <p>
 * items = {(w:1, v:6), (w:2, v:10), (w:3, v:12)}
 * maxWeight = 5
 * knapsack(items, maxWeight) = 22
 */
public class Knapsack {

    static class Item {
        int w;
        int v;

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    /**
     * brut force solution
     */
    public int knapsack(List<Item> items, int maxWeight) {
        List<Item> sumList = new ArrayList<>();
        int maxValue = 0;
        for(int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if(item.w < maxWeight) {
                sumList.add(new Item(item.w, item.v));
                if (item.v > maxValue)
                    maxValue = item.v;
                int sumListSize = sumList.size();
                for (int j = 0; j < sumListSize; j++) {
                    if (j == i) continue;
                    Item sumItem = sumList.get(j);
                    if (sumItem.w + item.w < maxWeight) {
                        sumList.add(new Item(sumItem.w + item.w, sumItem.v + item.v));
                        if (sumItem.v + item.v > maxValue)
                            maxValue = sumItem.v + item.v;
                    }
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        List<Item> input = Arrays.asList(new Item(1, 6), new Item(2, 10), new Item(3, 12));
        System.out.println(k.knapsack(input, 5));
        System.out.println("knapsack(input,5) = 22 : " + (k.knapsack(input, 5) == 18));

    }
}
