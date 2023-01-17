

import java.util.*;

public class Constants {

    public static final List<Character> RUS_ALPHABET_SMALL = Arrays.asList(' ', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');
    public static final List<Character> RUS_ALPHABET_CAPITAL = Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я');
    //  public static final String LAT_ALPHABET_SMALL = "abcdefghijklmnopqrstuvwxyz";
    //   public static final String LAT_ALPHABET_CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //  public static final String NUMERAL = "0123456789";
    public static final List<Character> SYMBOL = Arrays.asList(' ', '.', '-', ',', ':', ';', '!','\n','?', '"', '—');

    public static ArrayList<Character> characterPattern() {
        ArrayList<Character> mapAlphabet = new ArrayList<>();
        mapAlphabet.addAll(RUS_ALPHABET_SMALL);
        mapAlphabet.addAll(RUS_ALPHABET_CAPITAL);
        mapAlphabet.addAll(SYMBOL);

        return mapAlphabet;
    }

}

