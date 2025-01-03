// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class DNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        // Calculate the number of 10-character substrings in 's'
        int substringLengthLimit = s.length() - 10;
        // Create a map to store counts of each DNA sequence
        Map<String, Integer> sequenceCounts = new HashMap<>();
        // List to store the DNA sequences that appear more than once
        List<String> repeatedSequences = new ArrayList<>();

        // Iterate through the string checking for 10-character long substrings
        for (int i = 0; i <= substringLengthLimit; ++i) {
            // Extract the 10-character substring starting at index 'i'
            String currentSubstring = s.substring(i, i + 10);
            // Increase the count of the current DNA sequence in the map
            sequenceCounts.put(currentSubstring, sequenceCounts.getOrDefault(currentSubstring, 0) + 1);
            // If this is the second occurrence of the DNA sequence, add it to the answer list
            if (sequenceCounts.get(currentSubstring) == 2) {
                repeatedSequences.add(currentSubstring);
            }
        }
        // Return the list of repeated DNA sequences
        return repeatedSequences;
    }
}
