package priv.patrick.order.pojo;

import java.util.HashMap;
import java.util.Map;

public enum OrderState {
    INIT(0, "待支付"),
    PAID(1, "已支付");

    private int state;

    private String info;

    private OrderState(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    private static Map<Integer, OrderState> map = new HashMap<>();
    static {
        for (OrderState orderState : OrderState.values()) {
            map.put(orderState.getState(), orderState);
        }
    }

    public static OrderState getEnumByState(int state) {
        return map.get(state);
    }
}
