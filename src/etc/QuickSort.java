package etc;

import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> k = generateRandomArray(1000, 1000);
        System.out.println("generated: ");
        arrayDump(k);
        QuickSort qs = new QuickSort(k);
        System.out.println("sort: ");
        arrayDump(qs.sort());
    }

    private ArrayList<Integer> list;

    public QuickSort(ArrayList<Integer> list) {
        this.list = list;
    }

    public List<Integer> sort() {
        return this.sort(this.list);
    }

    public List<Integer> sort(List<Integer> list) {
        if (list.size() <= 0) {
            return list;
        }
        return this.sort(list.subList(1, list.size()), list.get(0));
    }

    public List<Integer> sort(List<Integer> list, int pivot) {
        ArrayList<Integer> smallList = new ArrayList<>();
        ArrayList<Integer> largeList = new ArrayList<>();
        for (int v: list) {
            if (v <= pivot) {
                smallList.add(v);
            } else {
                largeList.add(v);
            }
        }
        ArrayList<Integer> resList = new ArrayList<>();
        resList.addAll(sort(smallList));
        resList.add(pivot);
        resList.addAll(sort(largeList));
        return resList;
    }

    public static void arrayDump(List<Integer> list) {
        System.out.println(String.join(" ", list.stream().map(String::valueOf).collect(Collectors.toList())));
    }

    public static ArrayList<Integer> generateRandomArray(int length, int max) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add((int) (Math.random() * max));
        }
        return arr;
    }
}
