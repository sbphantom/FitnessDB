package fitnessdb;
/**
 * An instance of this class holds a list of fitness classes loaded from the text file
 * classSchedule.txt.
 * @author Adeola Asimolowo
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
            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                if(line.trim().isEmpty()){ break; }
                this.classes[index] = parseFitnessClass(line);
                this.numClasses++;
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

    public FitnessClass[] getClasses() {
        return classes;
    }

    public void setClasses(FitnessClass[] classes) {
        this.classes = classes;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < classes.length; i++){
            FitnessClass class = classes[i];
            sb.append(String.format("%s - %s, %s, %s", ));
        }
    }
}



