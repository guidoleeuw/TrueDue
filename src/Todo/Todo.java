package Todo;

import java.util.Date;

public class Todo {
    public Todo(String name, String desc, PriorityEnum priority, Date deadline, int SP) {
        this.name = name;
        this.desc = desc;
        this.priority = priority;
        this.deadline = deadline;
        this.SP = SP;
    }

    public Todo(){}

    enum PriorityEnum {
        highest,
        high,
        medium,
        low
    }

    private String name;
    private String desc;
    private PriorityEnum priority;
    private Date deadline;
    private int SP;

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

    public Todo deserialize(String raw) {
        String[] deserializedRaw = raw.split(",");
        return new Todo(deserializedRaw[0], deserializedRaw[1], PriorityEnum.values()[Integer.parseInt(deserializedRaw[2])],  new Date(deserializedRaw[3]), Integer.parseInt(deserializedRaw[4]));
    }

    @Override
    public String toString() {
         String strPrio =  priority.toString();
         String strDate = deadline.toString();
         String strSP = Integer.toString(SP);
         return name+ desc + strPrio + strDate + strSP;
    }
}
