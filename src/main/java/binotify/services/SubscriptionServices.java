package binotify.services;

import binotify.formats.subscription;

import javax.jws.*;

@WebService
public interface SubscriptionServices {

    @WebMethod
    public subscription[] getSubscription() throws Exception;

    @WebMethod
    public boolean addSubscription(int creator_id, int subscriber_id);

    @WebMethod
    public boolean approveSubscription(int creator_id, int subscriber_id);

    @WebMethod
    public boolean rejectSubscription(int creator_id, int subscriber_id);

    @WebMethod
    public boolean checkSubscription(int creator_id, int subscriber_id);

}
