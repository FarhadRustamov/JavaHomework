package animal_properties;

import animals.Animal;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalProperties {

    public static boolean fillAnimalProperties(Animal animal, Scanner scanner) { // возвращаемый тип boolean для того чтобы если у животного не будет возраста или имени - не создавать его
        System.out.println("Как зовут ваше животное?");
        animal.setName(scanner.nextLine());
        int i = 0;
        while (i < 3) {
            System.out.println("Сколько лет вашему животному?");
            String age = scanner.nextLine();
            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher matcher = pattern.matcher(age);
            if (matcher.find()) {
                animal.setAge(Integer.parseInt(age));
                break;
            } else if (i == 2) {
                System.out.println("Количество попыток исчерпано! Не удалось создать животное.");
                return false;
            } else {
                System.out.print("Введите целое число! ");
            }
            i++;
        }
        int j = 0;
        while (j < 3) {
            System.out.println("Какой вес у вашего животного?");
            String weight = scanner.nextLine().replace(",", "."); // чтобы дабл ошибку не кидал, если юзер ввел дробное число через запятую
            Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
            Matcher matcher = pattern.matcher(weight);
            if (matcher.find()) {
                animal.setWeight(Double.parseDouble(weight));
                break;
            } else if (j == 2) {
                System.out.println("Количество попыток исчерпано! Не удалось создать животное.");
                return false;
            } else {
                System.out.print("Введите целое или дробное число! ");
            }
            j++;
        }
        System.out.println("Какого цвета ваше животное?"); // на цвет тоже можно поставить ограничения, но уже не вижу смысла в этом
        animal.setColor(scanner.nextLine());
        return true;
    }
}
