package watchMovie.constant;

public enum UserType {
    Manager(0,"manager"),
    Staff(1,"staff"),
    User(2,"user");

    private int type;
    private String desc;
    UserType(int type,String desc){
        this.desc=desc;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
