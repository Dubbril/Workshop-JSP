package model;

import java.util.Date;
import java.util.Map;

public class MemberTable {

    private Database db;

    public MemberTable(Database db) {
        this.db = db;
    }

    public void deleteUnactivated() {
        String sql = "delete from member "
                + " where activated=0 "
                + " and datediff(curdate(),register_date)>7";
        db.update(sql);
    }

    public boolean add(Member member) {
        String sql = "insert into member "
                + " (username,password,name,"
                + " address,email,activated,"
                + " activate_code,register_date)"
                + " values(?,?,?,?,?,?,?,?)";
        try {
            int id = db.add(sql, member.getUsername(),
                    member.getPassword(),
                    member.getName(),
                    member.getAddress(),
                    member.getEmail(),
                    member.isActivated(),
                    member.getActivatedCode(),
                    member.getRegistDate());
            member.setId(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void update(Member member) {
        String sql = "update member "
                + " set username=?,password=?,name=?,address=?,"
                + " email=?,activated=?activate_code=?,"
                + " register_date=?"
                + " where id=?";
        db.update(sql, member.getUsername(),
                member.getPassword(),
                member.getName(),
                member.getAddress(),
                member.getEmail(),
                member.isActivated(),
                member.getActivatedCode(),
                member.getRegistDate(),
                member.getId());
    }

    public Member findByid(int id) {
        String sql = "select * from member where id=?";
        Map<String, Object> result = db.querrySingle(sql, id);
        if (result != null) {
            return new Member(id, (String) result.get("username"),
                    (String) result.get("password"),
                    (String) result.get("name"),
                    (String) result.get("address"),
                    (String) result.get("email"),
                    (Boolean) result.get("activated"),
                    (String) result.get("activate_code"),
                    (Date) result.get("register_date"));
        } else {
            return null;
        }
    }

    public Member findByUsername(String username) {
        String sql = "select * from member where username=?";
        Map<String, Object> result = db.querrySingle(sql, username);
        if (result != null) {
            return new Member((Integer) result.get("id"),
                    username,
                    (String) result.get("password"),
                    (String) result.get("name"),
                    (String) result.get("address"),
                    (String) result.get("email"),
                    (Boolean) result.get("activated"),
                    (String) result.get("activate_code"),
                    (Date) result.get("register_date"));
        } else {
            return null;
        }
    }

    public Member findByUP(String username, String password) {
        String sql = "select * from member "
                + " where username=? and password=?";
        Map<String, Object> result = db.querrySingle(sql, username, password);
        if (result != null) {
            return new Member((Integer) result.get("id"),
                    (String) result.get("username"),
                    (String) result.get("password"),
                    (String) result.get("name"),
                    (String) result.get("address"),
                    (String) result.get("email"),
                    (Boolean) result.get("activated"),
                    (String) result.get("activate_code"),
                    (Date) result.get("register_date"));
        } else {
            return null;
        }
    }

}
