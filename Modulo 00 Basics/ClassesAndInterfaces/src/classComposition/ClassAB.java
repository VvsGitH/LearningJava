package classComposition;

/* Composition is a way to achieve multiple inheritance in Java.
 * It could be seen as some sort of "manual" inheritance in which a class contains
 * an object of another class as attribute. Then the object is used to define the 
 * methods of the class so that they are the same as the one defined in that object.
 * Some say that is a good practice to use combination instead of inheritance. */

public class ClassAB {

    // Instantiating the classes
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();

    // Setting the attributes (only public) 
    int attrB = b.attributeB;

    // Setting the methods (only public)
    public void methodA() {
        a.methodA();
    }
    public void methodB() {
        b.methodB();
    }

}