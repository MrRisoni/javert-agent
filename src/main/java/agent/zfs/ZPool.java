package agent.zfs;

public class ZPool {

    private String disk;
    private  String State;

    public ZPool(String disk, String state) {
        disk = disk;
        State = state;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
