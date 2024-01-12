import java.util.LinkedList;

public class Test {
    public static void main(String[] args){
        LinkedList<String> animals = new LinkedList<>();

        //Add
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        animals.add(1,"Horse");

        //Access
        String str = animals.get(2);

        //Change
        animals.set(3,"Chicken");

        //Remove
        animals.remove(1);
        System.out.println("LinkedList: " + animals);
        System.out.print("Element at index 2: " + str);
    }
}
