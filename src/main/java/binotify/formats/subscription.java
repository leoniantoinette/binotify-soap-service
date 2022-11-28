package binotify.formats;

public class subscription {
    private int creator_id;
    private int subscriber_id;
    private String status;

    public subscription(int creator_id, int subscriber_id) {
        this.creator_id = creator_id;
        this.subscriber_id = subscriber_id;
        this.status = "PENDING";
    }

    public int getCreator_id() { return this.creator_id; }

    public int getSubscriber_id()  { return this.subscriber_id; }

    public String getStatus() { return this.status; }

    public void setCreator_id(int creator_id) { this.creator_id = creator_id; }

    public void setSubscriber_id(int subscriber_id) { this.subscriber_id = subscriber_id; }

    public void setStatus(String status) { this.status = status; }
}
