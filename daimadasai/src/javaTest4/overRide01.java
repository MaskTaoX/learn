package javaTest4;

import java.util.Objects;

public class overRide01 {
}
class person{
    private String name;
    private int age;
    private boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age &&
                gender == person.gender &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int hash = 17;

        return hash;
    }
}
