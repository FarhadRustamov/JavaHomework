public class Animal {
    private String name;
    private int age;
    private double weight;
    private String color;

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String yearDefinition;
        if (age == 1) {
            yearDefinition = " год";
        } else if (age >= 2 && age <= 4) {
            yearDefinition = " года";
        } else {
            yearDefinition = " лет";
        }
        return "Привет! Меня зовут " + name + ", мне " + age + yearDefinition + ", я вешу - " + weight + " кг, мой цвет - " + color + ".";
    }
}