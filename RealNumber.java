public class RealNumber {
  private double x;
  public RealNumber() {
    x = 5;
  }
  public RealNumber(double num) {
    x = num;
  }
  public double getX() {
    return x;
  }
  public String toString() {
    return "" + getX();
  }
}
