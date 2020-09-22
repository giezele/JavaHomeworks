package OOP;

// Difference between static and non-static method in Java

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Static sudėtis: " + StaticCalculator.add(4,5));
        System.out.println("Static atimtis: " + StaticCalculator.subtract(4,5));
        System.out.println("Static dalyba: " + StaticCalculator.divide(4,5));
        System.out.println("Static daugyba: " + StaticCalculator.multiply(4,5));

// System.out.println((new NonstaticCalculator()).add(8, 9));
        NonstaticCalculator nsc = new NonstaticCalculator();
        System.out.println("Instance sudėtis: " + nsc.add(8, 9));
        System.out.println("Instance atimtis: " + nsc.subtract(8, 9));
        System.out.println("Instance dalyba: " + nsc.divide(8, 9));
        System.out.println("Instance daugyba: " + nsc.multiply(8, 9));


    }
}
class StaticCalculator {
    public static int add(int i, int j){
        return i + j;
    }
    public static int subtract(int i, int j){
        return i - j;
    }
    public static int divide(int i, int j){
        return i / j;
    }
    public static int multiply(int i, int j){
        return i * j;
    }
}
class NonstaticCalculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int divide(int i, int j) {
        if (j == 0) {
            System.out.println("");
        }
        return i;
    }

    public int multiply(int i, int j) {
        return i * j;
    }
}

