package binotify.services;

import binotify.formats.subscription;

import javax.jws.*;

@WebService
public interface SubscriptionServices {

    @WebMethod
    public subscription[] getSubscription(String ip, String endpoint) throws Exception;

    @WebMethod
    public boolean addSubscription(String ip, String endpoint, int creator_id, int subscriber_id);

    @WebMethod
    public boolean approveSubscription(String ip, String endpoint, int creator_id, int subscriber_id);

    @WebMethod
    public boolean rejectSubscription(String ip, String endpoint, int creator_id, int subscriber_id);

    @WebMethod
    public boolean checkSubscription(String ip, String endpoint, int creator_id, int subscriber_id);

    @WebMethod
    public subscription[] validateDatabase(String ip, String endpoint) throws Exception;

}
