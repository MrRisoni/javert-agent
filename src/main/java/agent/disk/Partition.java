package agent.disk;

import lombok.Data;

@Data
public class Partition {

    private final String FileSystem;
    private final String Size;
    private final String Used;
    private final String Avail;
    private final String Mounted;

    public Partition(String fs, String sz, String usd, String avl, String mount) {
        this.FileSystem = fs;
        this.Size = sz;
        this.Used = usd;
        this.Avail = avl;
        this.Mounted = mount;
    }

    public String toString() {
        return "NAME " + this.FileSystem + "  USED " + this.Used + " AVAIL " + this.Avail + "  MOUNTPOINT " + this.Mounted;
    }
}
