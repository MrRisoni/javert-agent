package agent.disk;

public class Partition {

	private final String FileSystem;
	private final String Size;
  private final String Used;
	private final String Avail;
  private final String Mounted;



	public Partition(String fs, String sz, String usd,String avl, String mount) {
    this.FileSystem = fs;
    this.Size = sz;
    this.Used = usd;
    this.Avail = avl;
    this.Mounted = mount;
	}

	public String getFileSystem() {
		return this.FileSystem;
	}

  public String getSize() {
    return this.Size;
  }

  public String getUsed() {
    return this.Used;
  }

  public String getAvail() {
    return this.Avail;
  }

  public String getMounted() {
    return this.Mounted;
  }
}
