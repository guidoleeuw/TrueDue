package Todo;


import java.text.ParseException;
import java.util.Date;

public class Todo implements Comparable<Todo> {
    private String name;
    private String desc;
    private PriorityEnum priority;
    private Date deadline;
    private int weigt;

    public Todo(String name, String desc, PriorityEnum priority, Date deadline) {
        this.name = name;
        this.desc = desc;
        this.priority = priority;
        this.deadline = deadline;
    }

    public Todo() {
    }

    public int getWeigt() {
        return weigt;
    }

    public void setWeigt(int weigt) {
        this.weigt = weigt;
    }

    public Todo deserialize(String raw) throws ParseException {
        String[] deserializedRaw = raw.split(",");
        return new Todo(deserializedRaw[0], deserializedRaw[1], PriorityEnum.values()[Integer.parseInt(deserializedRaw[2])], java.text.DateFormat.getDateInstance().parse(deserializedRaw[3]));
    }

    public String toReadebleString() {
        String strPrio = priority.toString();
        String strDate = deadline.toString();
        return String.format("%s    %s    %s    %s", name, desc, strPrio, strDate);
    }

    public String toWritebleString() {
        String strPrio = priority.toString();
        String strDate = deadline.toString();
        return String.format("%s;%s;%s;%s", name, desc, strPrio, strDate);
    }

    @Override
    public int compareTo(Todo to) {
        if (getPriority() == null || to.getPriority() == null) {
            return 0;
        }
        return getPriority().compareTo(to.getPriority());

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public Date getDeadline() {
        return deadline;
    }

}
