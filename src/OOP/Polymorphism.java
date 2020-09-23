package OOP;

import java.util.Arrays;
import java.util.Comparator;
// 1. Sukurti polimorfinį masyvą, kuris savyje laikys 3-jų tipų objektus.
//         Inicializuokite bent po vieną kiekvieno tipo objektą.
//         Ir atspausdinkite jų duomenis konsolėje ciklo pagalba.
// 2. Pasinaudodami CustomComparable išrikiuokite masyvą.
// ** Rikiuokite pagal String savybę.
// ** Rikiuokite pagal dvi savybes.


public class Polymorphism {

    static void sort(CustomComparable[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {
            for (int kidx = 0; kidx < arr.length - 1 - k; kidx++) {
                if (arr[kidx].compare(arr[kidx + 1])) {
                    CustomComparable temporary = arr[kidx + 1];
                    arr[kidx + 1] = arr[kidx];
                    arr[kidx] = temporary;
                }
            }
        }
    }
    public static void main(String[] args) {
        PersonX[] people = new PersonX[6];
        people[0] = new PersonX( "Petras", 66);
        people[1] = new Employee("Jonas", 22, 555);         //polymorphism
        people[2] = new Employee("Antanas", 66, 788);
        people[3] = new Employee("Ona", 66, 432);
        people[4] = new Janitor("Aloyzas", 33, 888, true);
        people[5] = new Janitor("Veronika", 51, 777, false);

        // for (int i = 0; i < people.length; i++) {
        //     System.out.println(people[i]);
        // }
        // System.out.println(Arrays.toString(people));

        System.out.println("Before sorting: " );

        for (PersonX i : people) {
            System.out.println((Arrays.asList(people).indexOf(i) + 1) + ". " + i);
        }
        sort(people);

        System.out.println("After sorting: ");
        for (PersonX i : people) {
            System.out.println((Arrays.asList(people).indexOf(i) + 1) + ". " + i);
        }

    }
}

interface CustomComparable {
    boolean compare(CustomComparable o);
}

class PersonX implements CustomComparable {
    private String name;
    private int age;

    public PersonX(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", age: " + age;
    }

    @Override
    public boolean compare(CustomComparable p) {
        // return this.age > ((PersonX) p).age;             //sort by age
        return this.name.compareTo(((PersonX) p).name) > 0;  //sort by name

        // if (this.age == ((PersonX) p).age) {
        //     this.name.compareTo(((PersonX) p).name);
        // }
        // return this.name.compareTo(((PersonX) p).name) > 0;
    }
}

    class Employee extends PersonX {
        private int cardId;

        public Employee(String name, int age, int cardId) {
            super(name, age);
            this.cardId = cardId;
        }

        public int getCardId() {
            return cardId;
        }
        // @Override
        // public String toString() {
        //     return  super.toString() +
        //             ", cardId: " + cardId;
        // }
    }

    class Janitor extends Employee {
        private boolean driverLicence;

        public Janitor(String name, int age, int cardId, boolean driverLicence) {
            super(name, age, cardId);
            this.driverLicence = driverLicence;
        }

        // @Override
        // public String toString() {
        //     return super.toString() + ", driverLicence: " + driverLicence;
        //
        // }
    }


