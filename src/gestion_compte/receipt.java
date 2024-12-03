package gestion_compte;

public class receipt extends recipe{

    private double total;

    public receipt(String title,double price,double total){
        super(title,price);
        this.total=total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String toString() {
        return "Total Order: " + total;
    }
    }
