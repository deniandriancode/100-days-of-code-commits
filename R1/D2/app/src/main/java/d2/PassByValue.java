package d2;


class Foo {
    private String attribute;

    public Foo(String a) {
        this.attribute = a;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}


public class PassByValue {
    public static void main(String[] args) {
        Foo f = new Foo("f");
        System.out.println("Attribute before change : " + f.getAttribute());
        changeReference(f); // It won't change the reference!
        modifyReference(f); // It will change the object that the reference variable "f" refers to!
        System.out.println("Attribute after change" + f.getAttribute());
    }

    public static void changeReference(Foo a) {
        // a will point to object that passed to the function
        Foo b = new Foo("b");
        a = b; // now a will point to b, which in turn will not cause any changes to object that passed to the function
    }

    public static void modifyReference(Foo c) {
        // c will point to object that passed to the function
        c.setAttribute("c"); // modifying c will modifying object that pssed to the function
    }
}
