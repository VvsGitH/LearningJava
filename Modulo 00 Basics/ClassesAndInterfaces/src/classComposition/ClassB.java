package classComposition;

// This class will be combined inside ClassAB

public class ClassB {

    public int attributeB = 20; 

    public void methodB() {
        System.out.println("I'm the method B. " + "My attribute is: " + attributeB);
    }
    
}