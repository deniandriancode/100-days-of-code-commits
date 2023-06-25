package d3;

class IIDemoClass {
    public IIDemoClass() {
        // constructor
        System.out.println("Constructor called");
    }

    /** initializer block */
    // this called first before constructor
    {
        System.out.println("Initializer called");
    }
}

public class InstanceInitializer {
    public static void main(String[] args) {
        IIDemoClass obj = new IIDemoClass();
    }
}
