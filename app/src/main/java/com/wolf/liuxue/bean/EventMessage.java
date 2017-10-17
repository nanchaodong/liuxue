package com.wolf.liuxue.bean;

import android.text.style.TtsSpan;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public class EventMessage {
    private int msgId;
    private Object object;

    public EventMessage(int msgId, Object object) {
        this.msgId = msgId;
        this.object = object;
    }

    public EventMessage() {
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "msgId=" + msgId +
                ", object=" + object +
                '}';
    }
}
