package fitnessdb;
/**
 * @author Adeola
 */
public class Family extends Member{
    private boolean guest;

    private final double FAMILYPRICE = 49.99; 
    
    @Override
    public double bill() {
        return FAMILYPRICE; 
    };
}
