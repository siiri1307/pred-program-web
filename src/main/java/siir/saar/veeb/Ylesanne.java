package siir.saar.veeb;

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

}
