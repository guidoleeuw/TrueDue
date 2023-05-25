package Todo;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {
    private final Scanner scanner;
    private final PrintWriter pr;
    public Loader() throws IOException {
        String path = ".";
        File file = new File(path);
        this.scanner = new Scanner(file);
        this.pr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
    }

    public ArrayList<Todo> load() throws ParseException {
        ArrayList<Todo> res = new ArrayList<>();
        while (scanner.hasNext()) {
            res.add(new Todo().deserialize(scanner.nextLine()));
        }
        return res;
    }

    public void write(Todo todo) {
        pr.println(todo.toString());
    }
}
