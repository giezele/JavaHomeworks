
package lt.giedre1.app;

// Sukurkite naują objektą iš duomenų įvestų per konsolę, objekto vidinius duomenis išspausdinkite.

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Encapsulation {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Person manoPersona = new Person();
        String[] susplitintasStringas = new String[4];
        try {
            System.out.println("Koks Jūsų vardas? ");
            manoPersona.setName(userInput.nextLine());
            // String vardas = userInput.nextLine();
            System.out.println("Pavardė? ");
            manoPersona.setSurname(userInput.nextLine());
            // String pavarde = userInput.nextLine();
            System.out.println("Amžius? ");
            manoPersona.setAge(userInput.nextInt());
            // int amzius = userInput.nextInt();
            while (manoPersona.getAge() == -1) {
                System.out.print("Žmogaus amžius turi būti nuo 0 - 125. Įveskite amžių: ");
                manoPersona.setAge(userInput.nextInt());
            }
            System.out.println("Kokio atlyginimo tikitės už šį darbą? ");
            // double atl = userInput.nextDouble();
            manoPersona.setSalary(userInput.nextDouble());
            // Person persona = new Person(vardas, pavarde, amzius, atl);
            // System.out.println(persona.toString());

            System.out.println("Duomenys apie asmenį: " + manoPersona.getName() + " " + manoPersona.getSurname() + " " + manoPersona.getAge() + " " + manoPersona.getSalary());

            // Parašykite programėlę, kuri skaito duomenis iš konsolės ir įrašo juos į failą.
            // System.out.println("Working Directory = " + System.getProperty("user.dir")); File relativeFile2 = new File("./data/irasomaKortele.csv");
            File relativeFile2 = new File("./data/irasomaKortele.csv");
            FileWriter fw = null;
            fw = new FileWriter(relativeFile2, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(manoPersona.getName() + " " + manoPersona.getSurname() + " " + manoPersona.getAge() + " " + manoPersona.getSalary());
            // bw.write(persona.getAge());
            bw.newLine();

            bw.close();
        } catch (Exception e) {
            System.out.println("I/O Exception");
        }

        // parašykite taip, kad skaitomi iš failo duomenys atsidurtų masyve.
        File skaitomasFile = new File("./data/irasomaKortele.csv");
        try {
            FileReader fileReader = new FileReader(skaitomasFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                susplitintasStringas = fileLine.split(" ");
                System.out.println(Arrays.toString(susplitintasStringas));

                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        // Sukurkite funkciją, kuri perskaito duomenis iš failo ir sukuria naują failą.
        // Jame tiesiog įrašo visas eilutes, kuriose yra vardai, kurių amžius yra >18 metų (filtruoja pagal amžių vardus).

        find18(susplitintasStringas);

    }

    public static void find18(String[] susplitintasStringas) {
        File skaitomasFile = new File("./data/irasomaKortele.csv");
        try {
            FileReader fileReader = new FileReader(skaitomasFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                susplitintasStringas = fileLine.split(" ");
                Person manoPersona = new Person();
            // cia seterius pasidaryti tam personai is splitstringo
                manoPersona.setName(susplitintasStringas[0]);
                manoPersona.setSurname(susplitintasStringas[1]);
                manoPersona.setAge(Integer.parseInt(susplitintasStringas[2]));
                manoPersona.setSalary(Double.parseDouble(susplitintasStringas[3]));
                int over18 = manoPersona.getAge();
                if (over18 >= 18) {
                    File relativeFile2 = new File("./data/personaOver18.csv");
                    FileWriter fw = null;
                    fw = new FileWriter(relativeFile2, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(manoPersona.getName() + " " + manoPersona.getSurname() + " " + manoPersona.getAge() + " " + manoPersona.getSalary());
                    bw.newLine();

                    bw.close();
                }
                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
class Person {
    private String name;
    private String surname;
    private int age;
    private double salary;

    public Person(){}

    public Person(String n, String surn, int age, double sal) {
        this.name = n;
        this.surname = surn;
        this.age = age;
        this.salary = sal;
    }

    public void setName(String n){
        this.name = n;
    }
    public void setSurname(String surn){
        this.surname = surn;
    }

    public void setAge(int age) {
        if (age < 0 || age >= 125) {
            this.age = -1;
        } else {
            this.age = age;
        }
    }

    public void setSalary(double sal) {
        this.salary = sal;
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
    public double getSalary() {
        return salary;
    }
}
