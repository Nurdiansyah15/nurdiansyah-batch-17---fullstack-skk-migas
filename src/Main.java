import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        List<String> list2 = Arrays.asList("Indonesia", "Malaysia", "Singapore", "Thailand");
        List<String> list4 = Arrays.asList("NewYork", "London", "Paris", "Tokyo");
        List<String> list5 = Arrays.asList("Elephant", "Tiger", "Kangaroo", "Panda");

        System.out.println("output: " + freqChar(list1));
        System.out.println();
        System.out.println("output: " + freqChar(list2));
        System.out.println();
        System.out.println("output: " + freqChar(list4));
        System.out.println();
        System.out.println("output: " + freqChar(list5));

    }

    public static String freqChar(List<String> arr) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                hashMap.put(arr.get(i).charAt(j), hashMap.getOrDefault(arr.get(i).charAt(j), 0) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> mapList = new ArrayList<>(hashMap.entrySet());
        mapList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder sb = new StringBuilder();

        List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
        Integer tempNum = 0;
        for (int i = 0; i < mapList.size(); i++) {
            if (i == 0) {
                temp.add(mapList.get(i));
                tempNum = mapList.get(i).getValue();
                continue;
            }
            if (Objects.equals(mapList.get(i).getValue(), tempNum)) {
                temp.add(mapList.get(i));
                if (i == mapList.size() - 1) {
                    String string = sortChar(temp);
                    sb.append(string);
                }
            } else {
                if (temp.size() > 1) {
                    String string = sortChar(temp);
                    sb.append(string);
                    tempNum = mapList.get(i).getValue();
                    temp.clear();
                    temp.add(mapList.get(i));
                } else {
                    sb.append(temp.get(0).getKey());
                    tempNum = mapList.get(i).getValue();
                    temp.clear();
                    temp.add(mapList.get(i));
                }

            }

        }
        System.out.println("input: " + arr);
        System.out.println("process: " + mapList);
        return sb.toString();
    }

    public static String sortChar(List<Map.Entry<Character, Integer>> chars) {
        chars.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        StringBuilder sb = new StringBuilder();
        for (var c : chars) {
            sb.append(c.getKey());
        }
        return sb.toString();
    }
}
