package agent.zfs;

public class ZFSSnapshot {

    private String name;
    private String used;

    public ZFSSnapshot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
