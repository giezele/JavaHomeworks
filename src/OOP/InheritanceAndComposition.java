package lt.giedre1.app;

public class InheritanceAndComposition {
    public static void main(String[] args) {
        // inheritance

        //composition
        Blossom flower1 = new Blossom(6, "white");
        Blossom flower2 = new Blossom(8, "red");
        Stem climbing1 = new Stem(1, 12);
        Plant plant1 = new Plant(flower1, climbing1);
        Plant plant2 = new Plant(flower2, climbing1);

        System.out.println(plant1);
        System.out.println(plant2);

    }
}
class Blossom {
    int petalCount;
    String petalColor;

    public Blossom(int petalCount, String petalColor) {
        this.petalCount = petalCount;
        this.petalColor = petalColor;
    }

    @Override
    public String toString() {
        return "Blossom{" +
                "petalCount=" + petalCount +
                ", petalColor='" + petalColor + '\'' +
                '}';
    }
}
class Stem {
    int stemCount;
    int stemHeight;

    public Stem(int stemCount, int stemHeight) {
        this.stemCount = stemCount;
        this.stemHeight = stemHeight;
    }

    @Override
    public String toString() {
        return "Stem{" +
                "stemCount=" + stemCount +
                ", stemHeight=" + stemHeight +
                '}';
    }
}
class Plant {
    private Blossom flower;
    private Stem climbing;

    public Plant(Blossom flower, Stem climbing) {
        this.flower = flower;
        this.climbing = climbing;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
