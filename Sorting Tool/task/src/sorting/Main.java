package sorting;

import java.lang.reflect.Array;
import java.util.*;


public class Main {
    private static Scanner scanner;
    private static List<String> allowedParameters = List.of("-dataType");
    private static HashMap<String, String> inputMap = new HashMap<>();
    private static String sortingMode;
    public static void main(final String[] args) {
        scanner = new Scanner(System.in);

        for (int i = 0; i < args.length; i += 1){
            String arg = args[i];
            if ("-sortIntegers".equals(arg)){
                inputMap.put(arg, "true");
            }else if ("-dataType".equals(arg)){
                inputMap.put(arg, args[i + 1]);
            }else if ("-sortingType".equals(arg)){
                if (i == args.length - 1) return;
                inputMap.put(arg, args[i + 1]);
            }
        }

        if (inputMap.containsKey("-sortIntegers")){
            outputSortedIntegers();
            return;
        }
        if(inputMap.containsKey("-sortingType")){
            String sortingTypeInput = inputMap.get("-sortingType");
            switch (sortingTypeInput){
                case "byCount":
                    sortingMode = "byCount";
                    break;
                case "natural":
                default:
                    sortingMode = "natural";
                    break;
            }

        }
        if (inputMap.containsKey("-dataType")){
            String dataTypeInput = inputMap.get("-dataType");
            switch (dataTypeInput) {
                case "long":
                    countLongs();
                    break;
                case "line":
                    countLines();
                    break;
                case "word":
                default:
                    countWords();
                    break;
            }
        }
    }

    private static void outputSortedIntegers(){
        ArrayList<Integer> intList = new ArrayList<>();
        while (scanner.hasNextInt()){
            intList.add(scanner.nextInt());
        }
        Collections.sort(intList);
        System.out.println("Total numbers: " + intList.size());
        System.out.print("Sorted data: ");
        for (int el : intList){
            System.out.print(el + " ");
        }
    }

    private static void countLongs(){
        int totalEntryCounts = 0;
        Map<Long, Integer> entryMap = new HashMap<>();
        while (scanner.hasNextLong()){
            totalEntryCounts += 1;
            Long cand = scanner.nextLong();
            if (entryMap.containsKey(cand)){
                entryMap.put(cand, entryMap.get(cand) + 1);
            }else{
                entryMap.put(cand, 1);
            }
        }

        List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(entryMap.entrySet());
        if ("byCount".equals(sortingMode)){
            Collections.sort(entryList, new Comparator<Map.Entry<Long, Integer>>() {
                @Override
                public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                    int result = o1.getValue().compareTo(o2.getValue());
                    if (result == 0){
                        result = o1.getKey().compareTo(o2.getKey());
                    }
                    return result;
                }
            });
        }else{
            Collections.sort(entryList, new Comparator<Map.Entry<Long, Integer>>() {
                @Override
                public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
        }



        System.out.println(String.format("Total numbers: %d", totalEntryCounts));
        for (Map.Entry<Long, Integer> el : entryList){
            Long key = el.getKey();
            Integer val = el.getValue();
            Integer perc = 100 * val/totalEntryCounts;
            if ("byCount".equals(sortingMode)){
                System.out.println(String.format("%d: %d time(s), %d", key, val, perc) +"%");
            }else{
                for (int i = 1; i <= val; i++){
                    System.out.print(key + " ");
                }
            }
        }
    }

    private static void countLines(){
        int totalEntryCounts = 0;
        Map<String, Integer> entryMap = new HashMap<>();
        while (scanner.hasNextLine()){
            totalEntryCounts += 1;
            String cand = scanner.nextLine();
            if (entryMap.containsKey(cand)){
                entryMap.put(cand, entryMap.get(cand) + 1);
            }else{
                entryMap.put(cand, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entryMap.entrySet());
        if ("byCount".equals(sortingMode)){
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int result = o1.getValue().compareTo(o2.getValue());
                    if (result == 0){
                        result = o1.getKey().compareTo(o2.getKey());
                    }
                    return result;
                }
            });
        }else{
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
        }


        System.out.println(String.format("Total lines: %d", totalEntryCounts));
        for (Map.Entry<String, Integer> el : entryList){
            String key = el.getKey();
            Integer val = el.getValue();
            Integer perc = 100 * val/totalEntryCounts;
            if ("byCount".equals(sortingMode)){
                System.out.println(String.format("%s: %d time(s), %d", key, val, perc) +"%");
            }else{
                for (int i = 1; i <= val; i++){
                    System.out.print(key + " ");
                }
            }
        }
    }

    private static void countWords(){
        int totalEntryCounts = 0;
        Map<String, Integer> entryMap = new HashMap<>();
        while (scanner.hasNext()){
            totalEntryCounts += 1;
            String cand = scanner.next();
            if (entryMap.containsKey(cand)){
                entryMap.put(cand, entryMap.get(cand) + 1);
            }else{
                entryMap.put(cand, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entryMap.entrySet());
        if ("byCount".equals(sortingMode)){
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int result = o1.getValue().compareTo(o2.getValue());
                    if (result == 0){
                        result = o1.getKey().compareTo(o2.getKey());
                    }
                    return result;
                }
            });
        }else{
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
        }

        System.out.println(String.format("Total words: %d", totalEntryCounts));
        for (Map.Entry<String, Integer> el : entryList){
            String key = el.getKey();
            Integer val = el.getValue();
            Integer perc = 100 * val/totalEntryCounts;
            if ("byCount".equals(sortingMode)){
                System.out.println(String.format("%s: %d time(s), %d", key, val, perc) +"%");
            }else{
                for (int i = 1; i <= val; i++){
                    System.out.print(key + " ");
                }
            }
        }
    }
}
