package com.inSpring.rest.webservices.restfulwebservices.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about the user.")
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Size(min=2, message= "Name should be of min 2 characters")
    @ApiModelProperty(notes= "Name should have atleast 2 characters")
    private String name;


    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthdate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User(){

    }

    public User(Integer id, String name, Date birthdate)
    {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
