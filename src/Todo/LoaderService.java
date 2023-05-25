package Todo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LoaderService {
    private final Loader loader;

    public LoaderService() throws IOException {
        loader = new Loader();
    }

    public void save(Todo todo) {
        loader.write(todo);
    }

    public void save(ArrayList<Todo> todos) {
        todos.forEach(x -> loader.write(x));
    }

    public String getPrintableList() throws ParseException {
        ArrayList<Todo> data = loader.load();
        return convertListToPrintableList(data);
    }

    public String getOrderedPrintableList() throws ParseException {
        ArrayList<Todo> data = loader.load();

        ArrayList<Todo> out = new ArrayList<Todo>(returnSubsetBasedOmnPrio(data, PriorityEnum.highest));
        out.addAll(returnSubsetBasedOmnPrio(data, PriorityEnum.high));
        out.addAll(returnSubsetBasedOmnPrio(data, PriorityEnum.medium));
        out.addAll(returnSubsetBasedOmnPrio(data, PriorityEnum.low));

        return convertListToPrintableList(out);
    }

    private List<Todo> returnSubsetBasedOmnPrio(ArrayList<Todo> data, PriorityEnum e) {
        List<Todo> todo = new ArrayList<Todo>(data.stream().filter(x -> x.getPriority() == e).toList());
        Collections.sort(todo);
        Collections.reverse(todo);
        return todo;
    }

    private String convertListToPrintableList(List<Todo> list) {
        StringBuilder res = new StringBuilder();
        Iterator<Todo> iterator = list.iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next().toReadebleString());
        }
        return res.toString();
    }
}
