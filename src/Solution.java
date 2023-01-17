import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/*
Шифруем текст
*/

public class Solution {

    private static int numberOffset;
    private static String yourText;
    private static List<String> yourTextList;

    public static void main(String[] args) throws ExceptionAnswer, IOException {
        System.out.println("Привет! Давай зашифруем текст методом Цезаря? \n Введи пожалуйста цифру:");
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            throw new ExceptionAnswer("Нет, нет, введи именно цифру! Это важно \uD83D\uDE00");
        }
        numberOffset = console.nextInt();


            System.out.println("Если хотите кодировать свой текст введите \"д\", если использовать мой \"н\"");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("д")) {
                System.out.println("Введите свой текст:");
                Scanner text = new Scanner(System.in);
                yourText = text.nextLine();
                processingYourText();
            } else if (answer.equalsIgnoreCase("н")) {
                processingMyText();
            }

        if(!answer.equalsIgnoreCase("д")||!answer.equalsIgnoreCase("н")) {
            throw new ExceptionAnswer("Вы ввели неверный ответ, нужно выбрать \"д\" или \"н\"");
        }
    }

    public static void processingMyText() throws IOException {
        Path sourceText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block.txt");
        System.out.println("Это мой исходный текст:");

        List<String> sourceList = Files.readAllLines(sourceText);
        for (String str : sourceList) {
            System.out.println(str);
        }

        System.out.println("\n Закодированный текст:\n ");
        for (String st : Action.encodeMyText(Solution.numberOffset)) {
            System.out.println(st);
        }

        System.out.println("\n Раскодируем обратно:\n ");
        System.out.println(Action.decodeMyText(numberOffset));

    }

    public static void processingYourText() throws IOException {
        System.out.println("\n Закодированный текст:\n ");
        System.out.println(Action.encodeYourText(Solution.numberOffset, Solution.yourText));


        System.out.println("\n Раскодируем обратно:\n ");
        System.out.println(Action.decodeYourText(numberOffset, Action.encodeYourText(Solution.numberOffset, Solution.yourText)));

    }
}

