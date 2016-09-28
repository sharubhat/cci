package java8.java_lambda_expressions_n_streams.lambda_expressions_part_3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharath on 4/20/16.
 */
public class PredicateExamples {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
        System.out.printf("Original Words: %s.%n", words);

        List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        System.out.printf("Short words: %s.%n", shortWords);

        List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        System.out.printf("Words with b : %s.%n", wordsWithB);

        List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2 == 0));
        System.out.printf("Words with even length : %s.%n", evenLengthWords);

        List<String> shortWords2 = ElementUtils.allMatches(words, s -> s.length() < 4);
        System.out.printf("Short words: %s.%n", shortWords2);

        List<String> wordsWithB2 = ElementUtils.allMatches(words, s -> s.contains("b"));
        System.out.printf("Words with b : %s.%n", wordsWithB2);

        List<String> evenLengthWords2 = ElementUtils.allMatches(words, s -> (s.length() % 2 == 0));
        System.out.printf("Words with even length : %s.%n", evenLengthWords2);
    }
}
