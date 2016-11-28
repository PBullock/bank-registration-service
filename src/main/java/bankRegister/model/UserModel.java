package bankRegister.model;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private int is_sys_admin;
    private int project_option;

    public int getProject_option() {
        return project_option;
    }

    public void setProject_option(int project_option) {
        this.project_option = project_option;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIs_sys_admin() {
        return is_sys_admin;
    }

    public void setIs_sys_admin(int is_sys_admin) {
        this.is_sys_admin = is_sys_admin;
    }

    public UserModel(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
    public UserModel(int id, String name, String email, int is_sys_admin, int project_option) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.is_sys_admin = is_sys_admin;
        this.project_option = project_option;
    }
}
