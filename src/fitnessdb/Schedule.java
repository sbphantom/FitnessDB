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
    private FitnessClass [] classes = new FitnessClass[PARTITION_SIZE];
    private int numClasses;
    public static final int PARTITION_SIZE = 4;

    private void grow() {
        FitnessClass[] newArray = new FitnessClass[numClasses + PARTITION_SIZE];
        for (int i = 0; i < numClasses; i++) {
            newArray[i] = classes[i];
        }
        classes = newArray;
    }
    public boolean add(FitnessClass fitnessClass) {
        if (numClasses % PARTITION_SIZE == 0) grow();
        classes[numClasses] = fitnessClass;
        numClasses++;
        return true;

    }

    public Schedule(){
    }

    public FitnessClass findClass(FitnessClass target){
        for (int i = 0; i < numClasses; i++){
            if (classes[i].equals(target)){
                return classes[i];
            }
        }
        return null;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public void load(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty() || line.split(" ").length != 4) {
                    //throw exception?
                    continue;
                }
                String[] args = line.split(" ");

                Offer classInfo = Offer.getOffer(args[0]);
                Instructor instructor = Instructor.getInstructor(args[1]);
                Time time = Time.getTime(args[2]);
                Location studio = Location.getLocation(args[3]);
                FitnessClass fitnessClass = new FitnessClass(classInfo, instructor, studio, time);
                add(fitnessClass);

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
        return new FitnessClass(offer, instructorName, country, classTime);
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
        for (FitnessClass aClass : classes) {
            sb.append(String.format("%s - %s, %s, %s", aClass.getOffer().toString(), aClass.getInstructor().toString(), aClass.getTime().toString(), aClass.getStudio().toString()));
        }

        return sb.toString();
    }
}



