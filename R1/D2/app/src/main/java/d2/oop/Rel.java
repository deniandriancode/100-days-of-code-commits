package d2.oop;

import java.util.List;

/*
 * I read this from howtodoinjava.com, here is the link:
 * https://howtodoinjava.com/java/oops/association-aggregation-composition/
 * It has a lot of high quality java related tutorials
 */

public class Rel {
    public static void main(String[] args) {

    }
}


// === Association
// The association refers to relationships whose participant objects have
// independent lifecycles and there is no ownership between the objects.
class Teacher {
    List<Student> students;

    public void teach() {

    }
}

class Student {
    List<Teacher> teachers;

    public void learn() {

    }
}

// === Aggregration
// Refers to relationship between two classes such that objects of both classes
// can have independent lifecycle, but object of one class will belong to a
// specific object of the another class in its lifetime. 
class CellPhone {
    CellBattery battery;

    public void ring() {

    }
}

class CellBattery {
    short remainingEnergy;

    public void charge() {

    }
}

// === Composition
// Refers to relationships where two objects don’t have an independent lifecycle,
// and if the parent object is deleted, all child objects will also be deleted.
class Question {
    int id;
    String text;
    List<Answer> answers;
}

class Answer {
    long id;
    String text;
    boolean correct;
}
