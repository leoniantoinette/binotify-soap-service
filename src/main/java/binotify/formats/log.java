package binotify.formats;

public class log {

    private String description;
    private String IP;
    private String endpoint;
    public log(String description, String IP, String endpoint) {
        this.description = description;
        this.IP = IP;
        this.endpoint = endpoint;

    }

    public String getDescription() { return this.description; }

    public String getIP() { return this.IP; }

    public String getEndpoint() { return this.endpoint; }

    public void setDescription(String description) { this.description = description; }

    public void setIP(String IP) { this.IP = IP; }

    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }

}
