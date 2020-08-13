package com.ifi.models;

public class Staff {

    private String name;

    private String age;

    public Staff(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Staff() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Staff [name=" + name + ", age=" + age + "]";
    }


}
