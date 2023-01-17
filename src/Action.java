

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Action {

    public static List<String> encode(int nummerOffset) throws IOException {

        Path sourceText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block.txt");
        Path encodedText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block2.txt");
        List<String> sourceList = Files.readAllLines(sourceText);
        List<Character> listCollectingCharacter = new ArrayList<>();
        System.out.println("Это наш исходный текст:");
        List<String> encodedlist = null;
        for (String str : sourceList) {                                           // здесь я вывожу на экран исходный текст
            System.out.println(str);
        }
        for (String str : sourceList) {                                           // здесь я перебираю строки моего незашифрованного текста
            char[] chars = str.toCharArray();                                     // каждую строку представляю массивом символов
            for (int i = 0; i < chars.length; i++) {                              //перебираю массив символов
                for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата
                    int k = 0;
                    if (chars[i] == Constants.characterPattern().get(j)) {        // если символ из массива равен символу из списка
                        k = j + nummerOffset;                                     // создаю индекс смещения для шифра
                        if (k > Constants.characterPattern().size()) {            // если индекс выйдет за границы моего образца алфавита
                            k = k - 1 - Constants.characterPattern().size();      // то рассчитаю на сколько вышло и это будет новый коэффициент смещения
                        }
                        listCollectingCharacter.add(Constants.characterPattern().get(k));

                        StringBuilder sb = new StringBuilder();
                        for (Character ch : listCollectingCharacter) {
                            sb.append(ch);
                        }
                        Files.writeString(encodedText, sb + "\r");
                    }
                }
            }
        }
        encodedlist = Files.readAllLines(encodedText);
        return encodedlist;
    }

    public static List<String> decode(int nummerOffset) throws IOException {
        List<Character> listCollectingCharacter = new ArrayList<>();
        List<String> decodedlist = null;
        Path encodedText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block2.txt");
        List<String> encodedList = Files.readAllLines(encodedText);

        for (String str : encodedList) {                                           // здесь я перебираю строки моего незашифрованного текста
            char[] chars = str.toCharArray();                                     // каждую строку представляю массивом символов
            for (int i = 0; i < chars.length; i++) {                              //перебираю массив символов
                for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата
                    int k = 0;
                    if (chars[i] == Constants.characterPattern().get(j)) {        // если символ из массива равен символу из списка
                        k = j - nummerOffset;                                     // создаю индекс смещения для шифра
                        if (k < 0) {            // если индекс выйдет за границы моего образца алфавита
                            k = Constants.characterPattern().size() + k;      // то рассчитаю на сколько вышло и это будет новый коэффициент смещения
                        }
                        listCollectingCharacter.add(Constants.characterPattern().get(k));

                        StringBuilder sb = new StringBuilder();
                        for (Character ch : listCollectingCharacter) {
                            sb.append(ch);
                        }
                        Files.writeString(encodedText, sb + "\r");
                    }
                }
            }
        }
        decodedlist = Files.readAllLines(encodedText);
        return decodedlist;
    }
}