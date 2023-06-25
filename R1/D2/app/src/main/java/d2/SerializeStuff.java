package d2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo implements Serializable {
    public int a;
    public String b;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class SerializeStuff {
    public static void main(String[] args) {
        Demo demoObj1 = new Demo(1, "gfg");
        String filename = "file.ser";

        // serialization
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(demoObj1);
            System.out.println("Object has been serialized ");

            out.close();
            file.close();
        } catch (IOException e) {
            System.err.println("IOException is caught");
        }

        Demo demoObj2 = null;

        // deserialization
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream inp = new ObjectInputStream(file);

            demoObj2 = (Demo) inp.readObject();

            inp.close();
            file.close();
            System.out.println("Result :");
            System.out.println("a :: " + demoObj2.a);
            System.out.println("b :: " + demoObj2.b);
        } catch (IOException e) {
            System.err.println("IOException is caught");
        } catch (ClassNotFoundException ce) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
