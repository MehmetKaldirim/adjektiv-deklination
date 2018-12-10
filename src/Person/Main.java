package Person;

public class Main {
    public static void main(String[] args) {

        Teacher me = new Teacher("Stefano", "s");
        Student alice = new Student("Alice", "A:");
        Student lara = new Student("Lara", "A:");
        Student noelie = new Student("Neolie", "A:");
        me.sayHi();
        alice.greet(lara);
        alice.greet(lara);
        lara.greet(noelie);

        Homework h1 = new Homework("Invert an array");
        Homework h2 = me.inventNewHomework();
        Homework h3 = me.inventNewHomework();
        me.assignHomework(h1, alice);
        me.assignHomework(h2, alice);

        alice.doHomework();
        alice.doHomework();
    }
}