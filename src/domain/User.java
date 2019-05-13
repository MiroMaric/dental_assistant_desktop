
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class User extends Person implements GeneralDObject{
    
    private String username;
    private String password;


    public User() {
    }

    public User(String usernamme, String password) {
        this.username = usernamme;
        this.password = password;
    }
    
    public User(String usernamme, String password, String email, String firstname, String lastname) {
        super(firstname,lastname,email);
        this.username = usernamme;
        this.password = password;
    }

    public User(String usernamme, String password, String email, String firstname, String lastname, String adress, String phone) {
        super(firstname,lastname,email,adress,phone);
        this.username = usernamme;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "User{" + "username=" + username + '}';
    }

    @Override
    public String getClassName() {
        return "User";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(username).
                append("', '").append(password).
                append("', '").append(getEmail()).
                append("', '").append(getFirstname()).
                append("', '").append(getLastname()).
                append("', '").append(getAddress()).
                append("', '").append(getPhone()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getNameByColumn(int i) {
         String[] atributes = {"usernamme", "password", "email", "firstname", "lastname", "adress", "phone"};
         return atributes[i];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String lUsername = rs.getString("username");
        String lPassword = rs.getString("password");
        String email = rs.getString("email");
        String firstname= rs.getString("firstname");
        String lastname = rs.getString("lastname");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        return new User(lUsername, lPassword, email, firstname, lastname, address, phone);
    }

    @Override
    public String getWhereCondition() {
        return "username='"+username+"' and password='"+password+"'";
    }
}
