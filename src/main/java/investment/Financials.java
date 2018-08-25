package investment;

public class Financials {
  private double ROI;
  private double CAGR;
  private double IRR;

  public Financials(double ROI, double CAGR, double IRR) {
    this.ROI = ROI;
    this.CAGR = CAGR;
    this.IRR = IRR;
  };

  public double getROI(){
    return this.ROI;
  }
  public double getCAGR(){
    return this.CAGR;
  }
  public double getIRR(){
    return this.IRR;
  }
}
