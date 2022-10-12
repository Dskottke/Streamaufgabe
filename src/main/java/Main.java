import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        //sort array by stream

        int[] arrayint = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        int[] arraysorted = Arrays.stream(arrayint).sorted().toArray();

        Arrays.stream(arraysorted).forEach(number -> System.out.println(number));

        //sum all int in an array by stream

        int summit = Arrays.stream(arrayint).sum();
        System.out.println(summit);

        //multiply all int in an array by stream

        int product = Arrays.stream(arrayint).reduce(1, (a, b) -> a * b);
        System.out.println(product);


        //read students.csv and collect to list of Student

        try {
            List<Student> eingelesen = Files.lines(Path.of("students.csv"))
                    .skip(1)
                    .distinct()
                    .filter(line -> (!line.isEmpty()))
                    .map(line -> line.split(","))
                    .map(line -> new Student(line[0], line[1], line[2], line[3]))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e);

        }
    }
}

