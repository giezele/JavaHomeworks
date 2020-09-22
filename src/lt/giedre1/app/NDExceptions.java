package lt.giedre1.app;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NDExceptions {
    public static void main(String[] args) {
        // 3.
        int res;
        try {
            res = 1 / 0;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 4. Sukurite failą su tokiais duomenimis: vardas, amžius, telefono numeris.
        // Duomenis perskaitykite ir išveskite į ekraną.
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File pagalbinisFile = new File("./data/kortele.txt");
        try {
            FileReader fileReader = new FileReader(pagalbinisFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                String[] splitString = fileLine.split(" |-");
                System.out.println(Arrays.toString(splitString));
                fileLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

