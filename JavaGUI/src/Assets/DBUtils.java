package Assets;

public class DBUtils {

    private String systemName, dbName, user, pass;

    private boolean isHome = true;

    public DBUtils() {
        if(isHome){
            systemName = "localhost";
            dbName = "jdbc:mysql://localhost:3306/summer_project";
            user = "root";
            pass = "MD05jun23md";
        }else{
            systemName = "selene.hud.ac.uk";
            dbName = "";
            user = "";
            pass = "";
        }
    }

    public String getConnectionUrl() {
        return "jdbc:mysql://localhost:3306/summer_project?useSSL=false";
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
