import Todo.LoaderService;
import Todo.PriorityEnum;
import Todo.Todo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        LoaderService service = new LoaderService();
        Todo todo = new Todo("First todo", "", PriorityEnum.highest, new Date());
        service.save(todo);
        if (args.length == 0) {
            System.out.print(service.getPrintableList());
        }
    }
}