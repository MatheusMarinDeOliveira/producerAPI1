package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO {

    @JsonProperty("idUser")
    public Integer idUser;

    @JsonProperty("name")
    public String name;

    @JsonProperty("password")
    public String password;

    public UserVO(Integer idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }

    public UserVO() {
    }

    public String getName() {
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
