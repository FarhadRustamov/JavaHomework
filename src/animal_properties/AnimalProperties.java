package animal_properties;

import animals.Animal;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalProperties {

    public static void fillAnimalProperties(Animal animal, Scanner scanner) {
        System.out.println("Как зовут ваше животное?");
        animal.setName(scanner.nextLine());
        while (true) {
            System.out.println("Сколько лет вашему животному?");
            String age = scanner.nextLine();
            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher matcher = pattern.matcher(age);
            if (matcher.find()) {
                animal.setAge(Integer.parseInt(age));
                break;
            } else {
                System.out.print("Введите целое число! ");
            }
        }
        while (true) {
            System.out.println("Какой вес у вашего животного?");
            String weight = scanner.nextLine().replace(",", "."); // чтобы дабл ошибку не кидал, если юзер ввел дробное число через запятую
            Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
            Matcher matcher = pattern.matcher(weight);
            if (matcher.find()) {
                animal.setWeight(Double.parseDouble(weight));
                break;
            } else {
                System.out.print("Введите целое или дробное число! ");
            }
        }
        System.out.println("Какого цвета ваше животное?");
        animal.setColor(scanner.nextLine());

    }
}
