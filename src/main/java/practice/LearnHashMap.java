package practice;

import java.util.HashMap;

public class LearnHashMap {
    public void AddHashMapValue() {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("IE", "Internet Explorer");
        hmap.put("Chrome", "Google Chrome");
        hmap.put("FireFox", "Mozilla FireFox");
        hmap.put("Safari", "Macbook Browser");

        System.out.println("Browser name: " + hmap.get("IE"));
        System.out.println("Browser name: " + hmap.get("Chrome"));
        System.out.println("Browser name: " + hmap.get("FireFox"));
        System.out.println("Browser name: " + hmap.get("Safari"));
        System.out.println(hmap);
    }

    public void hashMapProblem() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("James", 10);
        map.put("Lauren", 20);
        map.put("Sanders", 30);

        System.out.println("Size of map: " + map.size());
        // Check if a key called "James" and if present print the value
        if(map.containsKey("James")) {
            System.out.println(map.get("James"));
        }
    }
}