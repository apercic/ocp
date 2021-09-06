class Animal implements Cloneable{
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal ccc(Animal animal) throws CloneNotSupportedException {
        return (Animal) animal.clone();
    }

    //overriding is optional - if you want deep copy for example
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ClonableClassExample {
    public static void main(String args[]) {
        Animal aa = new Animal("ana", 33);
//        aa.clone();  can't access the clone() method from here
    }
}