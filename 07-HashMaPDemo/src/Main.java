import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Map<Integer, String> student = new HashMap<>();

        student.put(1,"Abc");
        student.put(2,"Def");
        student.put(3,"Ghi");
        student.put(3,"Xyz");

        //displaying all the elements
        System.out.println(student);

        //accessing individual elements

        Set<Map.Entry<Integer, String>> studentSet = student.entrySet();

        for(Map.Entry<Integer, String> studentEntrySet : studentSet)
        {
            System.out.println("ID: " + studentEntrySet.getKey() + " | Name: " + studentEntrySet.getValue());
        }

    }
}