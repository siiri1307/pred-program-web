package siir.saar.veeb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Ylesanne> ylesanded = looYlesanded();

    static public List<Ylesanne> looYlesanded() {
        List<Ylesanne> ylesanded = new ArrayList<>();
        ylesanded.add(new Ylesanne(1, "x jagub 3-ga, aga mitte 9-ga", "∃y(x=(1+1+1)*y) & ¬∃z(x=(1+1+1)*(1+1+1)*z)"));
        ylesanded.add(new Ylesanne(2, "x on kahe y-st suurema arvu korrutis", "∃q∃p(∃z(y+z+1=q) & ∃w(y+w+1=p) & (x=q*p))"));
        ylesanded.add(new Ylesanne(3, "x ei jagu ühegi y-st väiksema algarvuga", "A(x) := ∀y∀z(x = y * z -> y = 1 ∨ z = 1) & ¬(x = 1)" +
                "J(x,y) := ∃z(x=y*z) & ¬(y=0)" +
                "V(x,y) := ∃z(x + z = y & ¬(z = 0))" +
                "∀z(A(z) & V(z,y) -> ¬J(x,z))"));
        ylesanded.add(new Ylesanne(4, "x < y ning arvude x ja y vahel leidub täpselt üks algarv", "A(x) := ∀y∀z(x=y*z -> y=1 ∨ z=1) & ¬(x=1)" +
                "V(x,y) := ∃z(x+z+1=y)" +
                "∃a(V(x,a)&V(a,y)&A(a)& ∀b(V(x,b) & V(b,y) & A(b) -> b=a))"));

        return ylesanded;
    }

    static List<Ylesanne> getYlesanded(){

        return ylesanded;

    }

    public static Connection getABYhendus() throws ClassNotFoundException, SQLException  {

        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:~/test", "admin", "admin");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    }
}
