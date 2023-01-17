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
        int nummerOffset = console.nextInt();

        for (String st : Action.encode(nummerOffset)) {
            System.out.println(st);
        }
        System.out.println(Action.decode(nummerOffset).toString());


    }
}

