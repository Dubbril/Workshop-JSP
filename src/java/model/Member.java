package model;

import java.util.Date;

class Member {

    private int id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private boolean activated;
    private String activatedCode;
    private Date registDate;

    public Member(String username, String password, String name, String address,
            String email, boolean activated, String activateCode, Date registerDate) {
        this(0, username, password, name, address, email, activated, activateCode, registerDate);
    }

    public Member(int id, String username, String password, String name,
            String address, String email, boolean activated, String activateCode, Date registerDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
        this.activated = activated;
        this.activatedCode = activateCode;
        this.registDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivatedCode() {
        return activatedCode;
    }

    public void setActivatedCode(String activatedCode) {
        this.activatedCode = activatedCode;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }
}
