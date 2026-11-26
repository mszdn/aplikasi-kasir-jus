package uas2.model;

public class user {
    private int id;            // id_kasir dari tabel kasir
    private String username;
    private String password;

    public user() {}

    // constructor untuk login (tanpa id)
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // constructor lengkap (dipakai untuk return dari DAO)
    public user(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // getter / setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
