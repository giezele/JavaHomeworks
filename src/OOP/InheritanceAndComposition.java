package OOP;

import java.util.Arrays;

public class InheritanceAndComposition {
    public static void main(String[] args) {

        //composition
        Blossom fl1 = new Blossom(6, "white");
        Blossom fl2 = new Blossom(8, "red");
        Stem climbing1 = new Stem(1, 120);
        Plant plant1 = new Plant(fl1, climbing1);
        Plant plant2 = new Plant(fl2, climbing1);

        System.out.println(plant1);
        System.out.println(plant2);

        // inheritance
        GardenPlant gp1 = new GardenPlant("Canna", 6);
        System.out.println(gp1);
        Flowering f1 = new Flowering("Aster dumosa", 4, "full sun", 60 );
        Flowering f2 = new Flowering("Salvia", 7, "partial sun", 30);
        System.out.println(f1);
        System.out.println(f2);

        // init GardenBorder object
        GardenPlant gp2 = new GardenPlant("Miscantus", 5);

        Perennials pe1 = new Perennials("Molinia", 4,"full sun");
        Perennials pe2 = new Perennials("Heuchera", 5, "partial sun");

        Flowering f3 = new Flowering("Geranium", 4, "partial sun", 20);

        GardenBorder gb1 = new GardenBorder("front", new GardenPlant[]{gp1, gp2}, new Perennials[]{pe1, pe2}, new Flowering[]{f1, f2, f3});
        System.out.println(gb1);
    }
}
class GardenBorder {
    private String position;
    private GardenPlant[] thrillers;
    private Perennials[] fillers;
    private Flowering[] spillers;

    public GardenBorder(String position, GardenPlant[] thrillers, Perennials[] fillers, Flowering[] spillers) {
        this.position = position;
        this.thrillers = thrillers;
        this.fillers = fillers;
        this.spillers = spillers;
    }

    @Override
    public String toString() {
        return "GardenBorder:" +
                "\n position: " + position +
                "\n thrillers: " + Arrays.toString(thrillers) +
                "\n fillers: " + Arrays.toString(fillers) +
                "\n spillers: " + Arrays.toString(spillers);
    }
}

class GardenPlant {
    private String name;
    private int hardinessZone;

    public GardenPlant(String name, int hardinessZone) {
        this.name = name;
        this.hardinessZone = hardinessZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHardinessZone() {
        return hardinessZone;
    }

    public void setHardinessZone(int hardinessZone) {
        this.hardinessZone = hardinessZone;
    }

    @Override
    public String toString() {
        return "GardenPlant {" +
                "name: " + name +
                ", hardinessZone: " + hardinessZone +
                '}';
    }
}

class Perennials extends GardenPlant {
    private String exposure;

    public Perennials(String name, int hardinessZone, String exposure) {
        super(name, hardinessZone);
        this.exposure = exposure;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    @Override
    public String toString() {
        return  super.toString() + " exposure: " + exposure;
    }
}

class Flowering extends Perennials {
    private int height;

    public Flowering(String name, int hardinessZone, String exposure, int height) {
        super(name, hardinessZone, exposure);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Flowering perenials {" +
                "name: " + this.getName() +
                ", hardinessZone: " + this.getHardinessZone() +
                ", exposure: " + this.getExposure() +
                ", height: " + height +
                "} ";
    }
}

class Blossom {
    private int petalCount;
    private String petalColor;

    public Blossom(int petalCount, String petalColor) {
        this.petalCount = petalCount;
        this.petalColor = petalColor;
    }

    @Override
    public String toString() {
        return "Blossom: {" +
                "petalCount: " + petalCount +
                ", petalColor: " + petalColor +
                '}';
    }
}
class Stem {
    private int stemCount;
    private int stemHeight;

    public Stem(int stemCount, int stemHeight) {
        this.stemCount = stemCount;
        this.stemHeight = stemHeight;
    }

    @Override
    public String toString() {
        return " Stem: {" +
                "stemCount: " + stemCount +
                ", stemHeight: " + stemHeight +
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
        return "Plant: {"  + flower + climbing + '}';

    }
}

