package youga.github.app.bean;

import java.util.List;

/**
 * Created by liuwei on 2017/3/3.
 */

public class UserForm {
    private int total_count;
    private boolean incomplete_results;
    private List<User> items;

    public int getTotal_count() {
        return total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public List<User> getItems() {
        return items;
    }
}
