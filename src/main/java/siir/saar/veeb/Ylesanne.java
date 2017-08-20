package siir.saar.veeb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ylesanne {

  private final int number;
  private final String vaide;
  private final String lahendus;


  public Ylesanne(int number, String vaide, String lahendus) {
    this.number = number;
    this.vaide = vaide;
    this.lahendus = lahendus;
  }

  public int getNumber() {
    return number;
  }

  public String getVaide() {
    return vaide;
  }

  public String getLahendus() {
    return lahendus;
  }

  public static List<Ylesanne> getYlesanded() throws SQLException, ClassNotFoundException {

    List<Ylesanne> ylesanded = new ArrayList<>();

    Connection ab = Main.getABYhendus();

    Statement lause = ab.createStatement();
    String sql = "SELECT * from predylesanded;";
    ResultSet ylesandedRS = lause.executeQuery(sql);

    while(ylesandedRS.next()){

      int ylNr = ylesandedRS.getInt("jrk");
      String ylVaide = ylesandedRS.getString("vaide");
      String ylLahendus = ylesandedRS.getString("lahendus");

      ylesanded.add(new Ylesanne(ylNr, ylVaide, ylLahendus));

    }

    lause.close();
    ab.close();

    return ylesanded;

  }

}
