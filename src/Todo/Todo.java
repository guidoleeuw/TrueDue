package Todo;


import java.text.ParseException;
import java.util.Date;

public class Todo implements Comparable<Todo> {
    private String name;
    private String desc;
    private PriorityEnum priority;
    private Date deadline;
    private int SP;
    private int weigt;

    public Todo(String name, String desc, PriorityEnum priority, Date deadline, int SP) {
        this.name = name;
        this.desc = desc;
        this.priority = priority;
        this.deadline = deadline;
        this.SP = SP;
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
        return new Todo(deserializedRaw[0], deserializedRaw[1], PriorityEnum.values()[Integer.parseInt(deserializedRaw[2])], java.text.DateFormat.getDateInstance().parse(deserializedRaw[3]), Integer.parseInt(deserializedRaw[4]));
    }

    @Override
    public String toString() {
        String strPrio = priority.toString();
        String strDate = deadline.toString();
        String strSP = Integer.toString(SP);
        return name + desc + strPrio + strDate + strSP;
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

    public int getSP() {
        return SP;
    }

    enum PriorityEnum {
        highest,
        high,
        medium,
        low
    }
}
