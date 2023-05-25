import Todo.LoaderService;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    static LoaderService service;

    static {
        try {
            service = new LoaderService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 0) {
            System.out.print(service.getPrintableList());

        }
    }
}