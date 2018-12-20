package Person;

public class Person {

    public final String name;
    public final String surname;
    public final String email;

    Person(String name, String surname,String email) {
        this.name = name;
        this.surname = surname;
        this.email=email;
     }

    public String toString() {
        return name + " " + surname+" "+email;
    }





}