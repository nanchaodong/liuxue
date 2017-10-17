package com.wolf.liuxue.utils;

import com.wolf.liuxue.bean.EventMessage;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class EventPush {
    private static EventPush ins;
    private EventBus aDefault;

    private EventPush() {
        aDefault = EventBus.getDefault();
    }

    public static EventPush ins() {
        if (ins == null) {
            synchronized (EventPush.class) {
                if (ins == null) {
                    ins = new EventPush();

                }
            }
        }
        return ins;
    }

    public void register(Object o) {
        aDefault.register(o);
    }

    public void unRegister(Object o) {
        aDefault.unregister(o);
    }

    public void send(int code, Object o) {
        EventMessage message = new EventMessage(code, o);
        aDefault.post(message);
    }
}
