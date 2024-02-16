package fitnessdb;
/**
 * @author Adeola
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Schedule {
    private FitnessClass [] classes;
    private int numClasses;

    public Schedule(FitnessClass[] classes, int numClasses){
        this.classes = classes; 
        this.numClasses = numClasses; 
    }
    public void load(File file) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine() && index < numClasses) {
                String line = scanner.nextLine();
                classes[index] = parseFitnessClass(line);
                index++;
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }


    private FitnessClass parseFitnessClass(String line) {
        // Implement parsing logic here based on your file format
        // For example, split the line by a delimiter and extract relevant information
        String[] parts = line.split(",");

        Offer offer = Offer.valueOf(parts[0].toUpperCase());
        Instructor instructorName = Instructor.valueOf(parts[1].toUpperCase());
        Time classTime = Time.valueOf(parts[2].toUpperCase());
        Location country = Location.valueOf(parts[3].toUpperCase());

        // Create and return a new FitnessClass object
        return new FitnessClass(offer, instructorName, country, classTime, null, null);
    }
}


}
