import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
Шифруем текст
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("Привет! Давай зашифруем текст методом Цезаря? \n Введи пожалуйста цифру:");
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            System.out.println("Нет, нет, введи именно цифру! Это важно \uD83D\uDE00");
        }
        int numberOffset = console.nextInt();

        Path sourceText = Path.of("C:\\\\Users\\PC\\IdeaProjects\\CoderProject\\src\\Block.txt");
        System.out.println("Это наш исходный текст:");

        List<String> sourceList = Files.readAllLines(sourceText);
        for (String str : sourceList) {
            System.out.println(str);
        }

        System.out.println("\n Закодированный текст:\n ");
        for (String st : Action.encode(numberOffset)) {
            System.out.println(st);
        }

        System.out.println("\n Раскодируем обратно:\n ");
        System.out.println(Action.decode(numberOffset));




    }
}

