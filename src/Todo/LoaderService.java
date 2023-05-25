package Todo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LoaderService {
    private Loader loader;

    public LoaderService() throws IOException, ParseException {
        Loader loader = new Loader();
    }

    public String getPrintableList() throws ParseException {
        ArrayList<Todo> data = loader.load();
        return convertListToPrintableList(data);
    }

    public String getOrderedPrintableList() throws ParseException {
        ArrayList<Todo> data = loader.load();
        
        ArrayList<Todo> out = new ArrayList<Todo>(returnSubsetBasedOmnPrio(data, Todo.PriorityEnum.highest));
        out.addAll(returnSubsetBasedOmnPrio(data, Todo.PriorityEnum.high));
        out.addAll(returnSubsetBasedOmnPrio(data, Todo.PriorityEnum.medium));
        out.addAll(returnSubsetBasedOmnPrio(data, Todo.PriorityEnum.low));

        return convertListToPrintableList(out);
    }

    private List<Todo> returnSubsetBasedOmnPrio(ArrayList<Todo> data, Todo.PriorityEnum e) {
        List<Todo> todo = new ArrayList<Todo>(data.stream().filter(x -> x.getPriority() == e).toList());
        Collections.sort(todo);
        Collections.reverse(todo);
        return todo;
    }

    private String convertListToPrintableList(List<Todo> list) {
        StringBuilder res = new StringBuilder();
        Iterator<Todo> iterator = list.iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next().toString());
        }
        return res.toString();
    }
}
