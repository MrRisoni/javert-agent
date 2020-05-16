package agent.disk;

public class ZPool {

    private String Name;
    private  String State;

    public ZPool(String name, String state) {
        Name = name;
        State = state;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
