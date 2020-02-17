package kulloveth.developer.com.pagingsample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
}
