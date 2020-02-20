package entities;

import java.util.Objects;

public class User {

    private long id;
    private String name;
    private String sex;
    private byte age;
    private String email;
    private String ssn;

    public User(long id, String name, String sex, byte age, String email, String ssn) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public User(String name, String sex, byte age, String email, String ssn) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                sex == user.sex &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                ssn.equals(user.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, email, ssn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
