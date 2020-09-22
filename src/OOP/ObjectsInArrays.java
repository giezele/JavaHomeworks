package OOP;
// sukurkite funkciją, kuri perskaito duomenis ir sukuria naują failą. Jame tiesiog įrašo
// visas eilutes, kuriose yra vardai, kurių amžius yra >10 m (filtruoja pagal amžių vardus).

import java.util.Arrays;

public class ObjectsInArrays {
    public static void main(String[] args) {
        Dog suo1 = new Dog("Brisius", "taksas", 500, 12);
        Dog suo2 = new Dog("Reksas", "vilkšunis",  1200, 1);
        Dog suo3 = new Dog ();
        suo3.setName("Murzius");
        suo3.setBreed("kieminis");
        suo3.setAge(8);
        suo3.setPrice(15);
        Dog suo4 = new Dog("Dona", "kinų kuoduotoji", 10999, 2);

        // System.out.println(suo1.toString());

        Dog[] dogs = {suo1, suo2, suo3, suo4};
        for (Dog i : dogs) {
            System.out.println((Arrays.asList(dogs).indexOf(i) + 1) + ". " + i);
        }

        // insertion sort by Price
        double minPrice;
        double currentPrice;
        for (int i = 1; i < dogs.length; ++i) {
            Dog key = dogs[i];
            minPrice = dogs[i].getPrice();
            int j = i - 1;
            currentPrice = dogs[j].getPrice();
            while (j >= 0 && currentPrice > minPrice) {
                dogs[j + 1] = dogs[j];
                j = j - 1;
            }
            dogs[j + 1] = key;
        }
        System.out.println(" array after sorting:");
        for (Dog i : dogs) {
            System.out.println((Arrays.asList(dogs).indexOf(i) + 1) + ". " + i);
        }
    }
}
class Dog {
    private String name;
    private String breed;
    private double price;
    private int age;

    public Dog() {
    }

    public Dog(String n, String breed, double pr, int age) {
        this.name = n;
        this.breed = breed;
        this.price = pr;
        this.age = age;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setPrice(double pr) {
        this.price = pr;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + breed + ", amžius: " + age + ", kaina: " + price + "€";
    }

    // @Override
    // public int compareTo(Dog comparestu) {
    //     int compareage = ((Dog) comparestu).getAmzius();
    //     /* For Ascending order*/
    //     return this.amzius - compareage;
    //
    //     /* For Descending order do like this */
    //     //return compareage-this.amzius;
    // }
}
