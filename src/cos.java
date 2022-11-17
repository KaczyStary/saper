// Java program to demonstrate initializing
// an array of objects using a method

class GFG {

    public static void main(String args[])
    {

        // Declaring an array of student
        Student[] arr;

        // Allocating memory for 2 objects
        // of type student
        arr = new Student[2];

        // Creating actual student objects
        arr[0] = new Student();
        arr[1] = new Student();

        arr[0].setName("Pawel");

        System.out.println(arr[0].getName());

    }
}

// Creating a Student class with
// id and name as a attributes
class Student {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {

    }
}
