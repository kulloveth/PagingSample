package kulloveth.developer.com.pagingsample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "rickandmorty_table")
public class Result {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String gender;


    public Result(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return getId() == result.getId() &&
                getName().equals(result.getName()) &&
                getGender().equals(result.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender());
    }

}
