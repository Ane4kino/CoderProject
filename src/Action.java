

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Action {
    public static Path sourceText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block.txt");
    public static Path encodedText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block2.txt");

    public static List<String> encodeMyText(int numberOffset) throws IOException {
        int charNumber = 0;
        List<Character> listCollectingCharacter = new ArrayList<>();
        List<String> encodedlist = null;

        List<String> sourceList = Files.readAllLines(sourceText);

        for (String str : sourceList) {                                           // здесь я перебираю строки моего незашифрованного текста
            str = str + "\n";
            char[] chars = str.toCharArray();                                     // каждую строку представляю массивом символов
            for (char aChar : chars) {                                            //перебираю массив символов
                for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата

                    if (aChar == Constants.characterPattern().get(j)) {           // если символ из массива равен символу из списка
                        charNumber = j;
                        listCollectingCharacter.add(Constants.characterPattern().get(Action.encodingFactor(numberOffset, charNumber)));
                        StringBuilder sb = new StringBuilder();
                        for (Character ch : listCollectingCharacter) {
                            sb.append(ch);
                        }
                        Files.writeString(encodedText, sb);
                    }
                }
            }
        }
        encodedlist = Files.readAllLines(encodedText);
        return encodedlist;
    }

    public static int encodingFactor(int numberOffset, int charNumber) {
        int encodingFactor = charNumber + numberOffset;                                     // создаю индекс смещения для шифра
        if (encodingFactor > Constants.characterPattern().size()) {                         // если индекс выйдет за границы моего образца алфавита
            encodingFactor = encodingFactor - 1 - Constants.characterPattern().size();      // то рассчитаю на сколько вышло и это будет новый коэффициент смещения
        }
        return encodingFactor;
    }

    public static StringBuilder decodeMyText(int numberOffset) throws IOException {
        List<Character> listCollectingCharacter = new ArrayList<>();
        List<String> decodedlist = null;
        int charNumber = 0;
        StringBuilder sb = null;
        Path encodedText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block2.txt");
        List<String> encodedList = Files.readAllLines(encodedText);

        for (String str : encodedList) {                                          // здесь я перебираю строки моего незашифрованного текста
            char[] chars = str.toCharArray();                                     // каждую строку представляю массивом символов
            for (char aChar : chars) {                                            //перебираю массив символов
                for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата
                    int encodingFactor = 0;
                    if (aChar == Constants.characterPattern().get(j)) {           // если символ из массива равен символу из списка
                        charNumber = j;
                        listCollectingCharacter.add(Constants.characterPattern().get(Action.decodingFactor(numberOffset, charNumber)));
                        sb = new StringBuilder();
                        for (Character ch : listCollectingCharacter) {
                            sb.append(ch);
                        }
                    }
                }
            }
        }
        return sb;
    }

    public static int decodingFactor(int numberOffset, int charNumber) {
        int decodingFactor = charNumber - numberOffset;                                 // создаю индекс смещения для шифра
        if (decodingFactor < 0) {                                                       // если индекс выйдет за границы моего образца алфавита
            decodingFactor = Constants.characterPattern().size() + decodingFactor;      // то рассчитаю на сколько вышло и это будет новый коэффициент смещения
        }
        return decodingFactor;
    }

    public static String encodeYourText(int numberOffset, String yourText) throws IOException {
        int charNumber = 0;
        String result ="";
        char[] chars = yourText.toCharArray();                                     // каждую строку представляю массивом символов
        for (char aChar : chars) {                                            //перебираю массив символов
            for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата

                if (aChar == Constants.characterPattern().get(j)) {           // если символ из массива равен символу из списка
                    charNumber = j;

                    result=result+Constants.characterPattern().get(Action.encodingFactor(numberOffset, charNumber));
                }
            }
        }
        return result;
    }
    public static String decodeYourText(int numberOffset,String encodeYourText) throws IOException {
        int charNumber = 0;
        String result="";
            char[] chars = encodeYourText.toCharArray();                                     // каждую строку представляю массивом символов
            for (char aChar : chars) {                                            //перебираю массив символов
                for (int j = 1; j < Constants.characterPattern().size(); j++) {   // перебираю список образца алфавата
                    int encodingFactor = 0;
                    if (aChar == Constants.characterPattern().get(j)) {           // если символ из массива равен символу из списка
                        charNumber = j;
                        result=result+(Constants.characterPattern().get(Action.decodingFactor(numberOffset, charNumber)));
                    }
                }
            }

        return result;
    }
}