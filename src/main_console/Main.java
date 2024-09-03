package main_console;

import animals.Animal;
import data.AnimalSpecies;
import data.Command;
import animal_properties.AnimalProperties;
import factory.AnimalFactory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> listOfAnimals = new ArrayList<>();
        Command command;
        while (true) {
            System.out.printf("Пожалуйста, введите одну из команд: %s\n", Arrays.toString(Command.values()));
            String commandString = scanner.nextLine().trim().toUpperCase();
            if (Arrays.stream(Command.values()).map(Object::toString).anyMatch(s -> s.equals(commandString))) { // Вначале создает поток из массива энамов, потом каждый элемент преобразует в стринг (чтобы с искомым элементом были одного типа), а затем совершает поиск среди этого массива
                command = Command.valueOf(commandString);
                switch (command) {
                    case ADD:
                        int i = 0;
                        while (i < 3) {
                            System.out.printf("Какое животное вы хотите создать: %s\n", Arrays.toString(AnimalSpecies.values()) + "?");
                            String animalString = scanner.nextLine().trim().toUpperCase();
                            if (Arrays.stream(AnimalSpecies.values()).map(Object::toString).anyMatch(s -> s.equals(animalString))) {
                                Animal animal = AnimalFactory.createAnimal(AnimalSpecies.valueOf(animalString));
                                boolean isCreated = AnimalProperties.fillAnimalProperties(animal, scanner);
                                if (isCreated) {
                                    listOfAnimals.add(animal);
                                    animal.say();
                                }
                                break;
                            } else if (i == 2) {
                                System.out.println("Количество попыток исчерпано! Не удалось создать животное!");
                                break;
                            } else {
                                System.out.print("Такого животного не существует! ");
                            }
                            i++;
                        }
                        break;
                    case LIST:
                        if (listOfAnimals.isEmpty()) {
                            System.out.print("Пока ни одного животного не было создано! ");
                            continue;
                        }
                        for (Animal oneAnimal : listOfAnimals) {
                            System.out.println(oneAnimal);
                        }
                        break;
                    case EXIT:
                        scanner.close();
                        System.exit(0);
                }
            } else {
                System.out.print("Неверная команда! ");
            }
        }
    }
}

