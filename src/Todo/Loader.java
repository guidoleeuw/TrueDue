package Todo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {
    private final Scanner scanner;
    private final PrintWriter pr;

    public Loader() throws IOException {
        String path = "./saveFile";
        File file = new File(path);
        file.createNewFile();
        this.scanner = new Scanner(file);
        this.pr = new PrintWriter(path);
    }

    public ArrayList<Todo> load() throws ParseException {
        ArrayList<Todo> res = new ArrayList<>();
        while (scanner.hasNext()) {
            res.add(new Todo().deserialize(scanner.nextLine()));
        }
        return res;
    }

    public void write(Todo todo) {
        pr.println(todo.toWritebleString());
        pr.close();
    }
}
