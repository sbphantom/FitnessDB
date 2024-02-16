package fitnessdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Schedule {
    private FitnessClass [] classes;
    private int numClasses;

    public Schedule(FitnessClass[] classes, int numClasses){
        this.classes = classes; 
        this.numClasses = numClasses; 
    }
    public void load(File file) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < numClasses) {
                // Assuming each line represents a FitnessClass, parse the line and create FitnessClass objects
                classes[index] = parseFitnessClass(line);
                index++;
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                    e.printStackTrace();
                }
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
