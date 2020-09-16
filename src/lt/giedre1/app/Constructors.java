package lt.giedre1.app;

// Sukurkite naują objektą iš duomenų įvestų per konsolę, objekto vidinius duomenis išspausdinkite.

import java.util.Scanner;

public class Constructors {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Koks Jūsų vardas? ");
            String vardas = sc.nextLine();
            System.out.println("Pavarde? ");
            String pavarde = sc.nextLine();
            System.out.println("Amzius? ");
            int amzius = sc.nextInt();
            Person manoPersona = new Person();
            manoPersona.setName(vardas);
            manoPersona.setSurname(pavarde);
            manoPersona.setAge(amzius);
            System.out.println(manoPersona.getName() + " " + manoPersona.getSurname() + " " + manoPersona.getAge());
        }
}
class Person {
    private String name;
    private String surname;
    private int age;

    public void setName(String n){
        this.name = n;
    }
    public void setSurname(String s){
        this.surname = s;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }

    public int getAge() {
        return age;
    }
}

