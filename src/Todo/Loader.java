package Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    public Loader(File file, String path, Scanner scanner) throws IOException {
        this.file = new File(this.path);
        this.scanner = new Scanner(file);
        this.pr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
    }

    private File file;
    private String path = "";
    private Scanner scanner;
    private PrintWriter pr;

    public List<Todo> load() {
        ArrayList<Todo> res = new ArrayList<Todo>();
        while (scanner.hasNext()) {
            res.add(new Todo().deserialize(scanner.nextLine()));
        }
        return res;
    }

    public void write(Todo todo) {
        pr.println(todo.toString());
    }
}
