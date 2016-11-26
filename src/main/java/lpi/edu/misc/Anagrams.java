package lpi.edu.misc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Anagrams {

    public Set<Set<String>> findAnagrams(LinkedList<String> input) {
        Map<String, Set<String>> anagramap = new HashMap<>();
        input.forEach(word -> anagramap.computeIfAbsent(sortedCharsOf(word), k -> new HashSet<>()).add(word));
        return anagramap.values().stream().filter(set -> set.size() > 1).collect(Collectors.toSet());
    }

    private String sortedCharsOf(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "src/main/resources/wordlist.txt";
        File file = new File(inputFile);
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(new BufferedInputStream(fis), "ISO-8859-1");
        LinkedList<String> words = new LinkedList<>();
        Collections.addAll(words, scanner.useDelimiter(Pattern.compile("\\A")).next().split("\n"));

        long t1 = System.nanoTime();
        Set<Set<String>> ans = new Anagrams().findAnagrams(words);
        long t2 = System.nanoTime();
        System.out.println("Found " + ans.size() + " sets of anagrams. It took: " + (t2 - t1) * 1.0 / 1_000_000 + " millis.");
        ans.forEach(anagramSet -> System.out.println(setToString(anagramSet)));

    }

    private static String setToString(Set<String> input) {
        return String.join(" ", input);
    }

}
