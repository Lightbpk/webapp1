package app.entities;

public class User {
    private String name;
    private String password;

    public User(){
    }

    public User(String name,String password){
        this.name = name;
        this.password = password;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User {Name:"+name+" PSW:"+password;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        User user = (User) o;
        if(name != null ? !name.equals(user.name): user.name != null)return false;
        return  password != null ? password.equals(user.password): user.password == null;
    }
}