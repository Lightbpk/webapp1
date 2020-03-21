package app.entities;

public class Animal {
    private String photoURL;
    private String name;
    private String status;
    private String type;

    public Animal(){
    }

    public Animal(String photoURL, String name, String status, String type){
        this.photoURL = photoURL;
        this.name = name;
        this.status = status;
        this.type = type;
    }
    public String getReqLine(){
        return photoURL+","+name+","+status+","+type;
    }
    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{U:"+photoURL+" N:"+name+" S:"+status+" T:"+type+"}";
    }
}
