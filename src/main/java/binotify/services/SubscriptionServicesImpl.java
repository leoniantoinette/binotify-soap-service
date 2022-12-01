package binotify.services;

import binotify.formats.*;
import binotify.dao.*;
import javax.jws.*;
import java.util.*;

@WebService
public class SubscriptionServicesImpl implements SubscriptionServices {
    private subscriptionDao subscriptionDao = new subscriptionDao();

    @Override
    public subscription[] getSubscription(String ip, String endpoint) throws Exception{
        List<subscription> list = this.subscriptionDao.getSubscription();
        subscription[] res = new subscription[list.size()];
        for (int i=0; i<list.size(); i++) {
            subscription s = new subscription(list.get(i).getCreator_id(), list.get(i).getSubscriber_id());
            s.setStatus(list.get(i).getStatus());
            res[i] = s;
        }
        return res;
    }

    @Override
    public boolean addSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        System.out.println("ip " + ip + " endpoint " + endpoint);
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.addSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean approveSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        System.out.println("approveSubscription creator_id " + creator_id + " subscriber_id " + subscriber_id);
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.approveSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean rejectSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.rejectSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean checkSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.checkSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

}
