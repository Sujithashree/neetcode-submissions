

public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        if (pairs.size() == 0) return result;

        for (int i = 0; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            int j = i - 1;


            while (j >= 0 && pairs.get(j).key > current.key) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }

            pairs.set(j + 1, current);


            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}