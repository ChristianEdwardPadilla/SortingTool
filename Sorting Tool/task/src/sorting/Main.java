package sorting;

import java.util.*;


public class Main {
    private static Scanner scanner;
    private static List<String> allowedParameters = List.of("-dataType");
    public static void main(final String[] args) {
        scanner = new Scanner(System.in);

        /*
         notes on handling input:
         initialize hashmap HashMap<String, String>
         loop thru the args array, look for entries that are in the allowedparams array
         when found, the key is the allowedParam, the value is the following string

         then, have an ordered list of if...else if checks for each param
         */
        String dataTypeInput = "word";
        for (int i = 0; i < args.length; i += 2){
            String arg = args[i];
            if (!allowedParameters.contains(arg)) continue;
            switch (arg){
                case "-dataType":
                    if (!args[i+1].equals("")){
                        dataTypeInput = args[i+1];
                    }
                    break;
                default:
                    break;
            }
        }
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

    private static void countLongs(){
        int totalEntryCounts = 0;
        long maxEntry = Long.MIN_VALUE;
        int maxEntryCount = 0;
        while (scanner.hasNextLong()){
            totalEntryCounts += 1;
            long cand = scanner.nextLong();
            if (cand > maxEntry){
                maxEntry = cand;
                maxEntryCount = 1;
            }else if (cand == maxEntry){
                maxEntryCount += 1;
            }
        }
        double percentDouble = Math.floor(100 * (double) maxEntryCount / (double) totalEntryCounts);
        int percentage = (int) percentDouble;
        System.out.println(String.format("Total numbers: %d", totalEntryCounts));
        System.out.println(String.format("The greatest number: %d (%d time(s), %d", maxEntry, maxEntryCount, percentage) + "%)");
    }

    private static void countLines(){
        int totalEntryCounts = 0;
        String maxEntry = "";
        int maxEntryLength = 0;
        int maxEntryCount = 0;
        while (scanner.hasNextLine()){
            totalEntryCounts += 1;
            String cand = scanner.nextLine();
            int candLength = cand.length();

            if (candLength > maxEntryLength){
                maxEntry = cand;
                maxEntryLength = candLength;
                maxEntryCount = 1;
            }else if (candLength == maxEntryLength){
                maxEntryCount += 1;
            }
        }
        double percentDouble = Math.floor(100 * (double) maxEntryCount / (double) totalEntryCounts);
        int percentage = (int) percentDouble;
        System.out.println(String.format("Total lines: %d", totalEntryCounts));
        System.out.println("The longest line: " + "\n" + maxEntry);
        System.out.println(String.format("(%d time(s), %d", maxEntryCount, percentage) + "%)");
    }

    private static void countWords(){
        int totalEntryCounts = 0;
        String maxEntry = "";
        int maxEntryLength = 0;
        int maxEntryCount = 0;
        while (scanner.hasNext()){
            totalEntryCounts += 1;
            String cand = scanner.next();
            int candLength = cand.length();

            if (candLength > maxEntryLength){
                maxEntry = cand;
                maxEntryLength = candLength;
                maxEntryCount = 1;
            }else if (candLength == maxEntryLength){
                maxEntryCount += 1;
            }
        }
        double percentDouble = Math.floor(100 * (double) maxEntryCount / (double) totalEntryCounts);
        int percentage = (int) percentDouble;
        System.out.println(String.format("Total words: %d", totalEntryCounts));
        System.out.println(String.format("The longest word: %s (%d time(s), %d", maxEntry, maxEntryCount, percentage) + "%)");
    }
}