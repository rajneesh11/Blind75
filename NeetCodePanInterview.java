import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private ArrayList<Integer> list;
    private Map<Integer, List<Integer>> map;

    public Solution() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    // Insert
    public void insertIntoList(int value) {
        list.add(value);
        List<Integer> indices = map.getOrDefault(value, new ArrayList<>());
        indices.add(list.size() - 1);
        map.put(value, indices);
    }

    // Delete
    public void deleteFromList(int value) {
        if (!map.containsKey(value)) {
            return;
        }

        int index = list.indexOf(value);
        list.set(index, list.get(list.size() - 1));
        list.set(list.size() - 1, value);
        map.get(list.get(index)).set(map.getOrDefault(value, null).size() - 1, index);
        list.remove(list.size() - 1);
        map.get(value).remove(0/* new Integer(index) */);
    }

    public void printListAndMap() {
        System.out.println(list);
        System.out.println(map);
    }

}

public class NeetCodePanInterview {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.insertIntoList(3);
        solution.insertIntoList(4);
        solution.insertIntoList(5);
        solution.insertIntoList(4);
        solution.insertIntoList(5);
        solution.printListAndMap();
        solution.deleteFromList(4);
        solution.printListAndMap();
    }
}
