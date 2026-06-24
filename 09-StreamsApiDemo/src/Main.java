import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(30);


        //printing the numbers using stream api
        numbers.stream().forEach(System.out::println);

        //checking for even and odd using streams
        numbers.stream().filter((number)->number % 2 == 0).forEach(System.out::println);

        //making square of elements and storing them inside a new list
        List<Integer> squareList = numbers.stream().map((number) -> number * number).collect(Collectors.toList());

        //sum of all even numbers only
        Integer evenSum = numbers.stream().filter((number) -> number % 2 == 0).reduce(0,(number1, number2) -> number1+number2);
        System.out.println(evenSum);

        //find min and max from the list

        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max((a,b)->a.compareTo(b));

        //use of limit of excessing the number of elements

        numbers.stream().limit(3).forEach(System.out::println);

        Long count = numbers.stream().count();

        Optional<Integer> firstValue = numbers.stream().findFirst();

        List<Integer> skippedList = numbers.stream().skip(3).toList();
    }
}