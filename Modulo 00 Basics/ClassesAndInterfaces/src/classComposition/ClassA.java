package classComposition;

// This class will be combined inside ClassAB

public class ClassA {
    
    private int attributeA = 10; 

    public void methodA() {
        System.out.println("I'm the method A. " + "My attribute is: " + attributeA);
    }

}