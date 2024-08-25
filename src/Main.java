import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> listOfAnimals = new ArrayList<>();
        Instruction command = null;
        while (command != Instruction.EXIT) {
            System.out.println("Пожалуйста, введите комманду!");
            command = Instruction.valueOf(scanner.nextLine().trim().toUpperCase());
            switch (command) {
                case ADD:
                    System.out.println("Какое животное вы хотите создать?");
                    AnimalSpecies animalSpecies = AnimalSpecies.valueOf(scanner.nextLine().trim().toUpperCase());
                    Animal animal = null;
                    switch (animalSpecies) {
                        case CAT:
                            animal = new Cat();
                            break;
                        case DOG:
                            animal = new Dog();
                            break;
                        case DUCK:
                            animal = new Duck();
                    }
                    System.out.println("Как зовут ваше животное?");
                    animal.setName(scanner.nextLine());
                    System.out.println("Сколько лет вашему животному?");
                    animal.setAge(scanner.nextInt());
                    System.out.println("Какой вес у вашего животного?");
                    animal.setWeight(scanner.nextDouble());
                    scanner.nextLine(); // чтобы проглотить '\n’ после введенного числа, соответствующего весу
                    System.out.println("Какого цвета ваше животное?");
                    animal.setColor(scanner.nextLine());
                    listOfAnimals.add(animal);
                    animal.say();
                    break;
                case LIST:
                    if (listOfAnimals.isEmpty()) {
                        System.out.println("Пока ни одного животного не было создано!");
                        continue;
                    }
                    for (Animal oneAnimal : listOfAnimals) {
                        System.out.println(oneAnimal);
                    }
            }
        }
        scanner.close();
    }
}
