package kuznetsov.analyzer.service;

import java.util.ArrayList;
import java.util.List;

public class KmpAlg {

  public static List<Integer> searchOccurrencesByKmpAlg(String text, String pattern) {

    int[] prefixFunc = calcPrefixFunc(pattern);
    ArrayList<Integer> occurrences = new ArrayList<>();

    int patternIndex = 0;
    for (int textIndex = 0; textIndex < text.length(); textIndex++) {

      while (patternIndex > 0 && text.charAt(textIndex) != pattern.charAt(patternIndex)) {
        patternIndex = prefixFunc[patternIndex - 1];
      }

      if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
        patternIndex += 1;
      }

      if (patternIndex == pattern.length()) {
        occurrences.add(textIndex - patternIndex + 1);
        patternIndex = prefixFunc[patternIndex - 1];
      }
    }

    return occurrences;
  }

  public static int[] calcPrefixFunc(String str) {

    int[] prefixFunc = new int[str.length()];

    for (int strIndex = 1; strIndex < str.length(); strIndex++) {

      int j = prefixFunc[strIndex - 1];

      while (j > 0 && str.charAt(strIndex) != str.charAt(j)) {
        j = prefixFunc[j - 1];
      }

      if (str.charAt(strIndex) == str.charAt(j)) {
        j += 1;
      }

      prefixFunc[strIndex] = j;
    }

    return prefixFunc;
  }

}