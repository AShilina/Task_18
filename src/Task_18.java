/*Необходимо написать программу, которая будет выводить на экран текстовые данные из файла .txt, а потом в этот же файл перезаписывать текстовые данные, введенные вручную.
Количество строк после перезаписи должно быть столько же, сколько и в изначальном варианте.*/

import java.io.*;
import java.util.Scanner;

public class Task_18 {

    public static void main(String[] args) throws Exception {
        FileReader my_reader = new FileReader("D://file.txt");
        Scanner scan = new Scanner(my_reader);
        System.out.println("Текст из файла:");
        int lines_num = 0;
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
            lines_num++;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nКоличество строк в файле: " + lines_num + ". Такое количество строк доступно для перезаписи.\nВведите текст построчно.");
        String your_text;
        int i = 1;
        try (FileWriter writer = new FileWriter("D://file.txt"))
        {
            do {
                System.out.print("Ваш текст для строки " + i + ": ");
                your_text = reader.readLine();
                lines_num--;
                your_text = your_text + "\n";
                writer.write(your_text);
                i++;
            } while (lines_num > 0);
        } catch (IOException exc) {
            System.out.println("Произошла ошибка: " + exc);
        }
        System.out.println("\nСпасибо, ваш текст перезаписан!");
    }
}