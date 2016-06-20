package spring.example.prototype;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    protected int id;
    protected String msg;
    protected Date date;
    protected DateFormat format;
    protected EventType type;

    public Event(Date date, DateFormat format) {
        this.date = date;
        this.format = format;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + format.format(date) +
                '}';
    }
}
