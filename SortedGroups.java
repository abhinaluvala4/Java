import java.util.*;
import java.io.*;

public class SortedGroups {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            char[] s = br.readLine().trim().toCharArray();

            // Count frequency of each character
            int[] freq = new int[26];
            for (char c : s) freq[c - 'a']++;

            // Goal: lex largest permutation of S that can be split into
            // two non-decreasing subsequences.
            // Equivalent condition (Dilworth): no strictly decreasing subsequence of length 3.
            //
            // Greedy: at each position, try the largest available character.
            // If placing it would create a strictly decreasing run of length 3
            // (result[i-2] > result[i-1] > candidate), instead use the smallest
            // available character >= result[i-1] to break the run.
            // If no such character exists, fall back to the largest available.

            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                // Find largest available character
                int maxIdx = 25;
                while (maxIdx >= 0 && freq[maxIdx] == 0) maxIdx--;

                char candidate = (char) ('a' + maxIdx);

                if (i >= 2 && result[i-2] > result[i-1] && result[i-1] > candidate) {
                    // Would extend a strictly decreasing run of 3 — find smallest char >= result[i-1]
                    int need = result[i-1] - 'a';
                    int best = -1;
                    for (int j = need; j <= 25; j++) {
                        if (freq[j] > 0) { best = j; break; }
                    }
                    if (best != -1) {
                        candidate = (char) ('a' + best);
                    }
                    // else: no char >= result[i-1] available, keep largest (unavoidable)
                }

                result[i] = candidate;
                freq[candidate - 'a']--;
            }

            out.append(new String(result)).append('\n');
        }

        System.out.print(out);
    }
}
