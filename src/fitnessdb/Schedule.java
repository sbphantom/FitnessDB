package fitnessdb;

public class Schedule {
    private FitnessClass [] classes;
    private int numClasses;

    public Schedule(FitnessClass[] classes, int numClasses){
        this.classes = classes; 
        this.numClasses = numClasses; 
    }
    public void load(File file) throws IOException { }
}
