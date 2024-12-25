public class Table {
    private String tableId;
    private boolean isAvailable;
    private double price;
    private int availableSlot;

    public Table(String tableId, boolean isAvailable, double price, int availableSlot) {
        this.tableId = tableId;
        this.isAvailable = isAvailable;
        this.price = price;
        this.availableSlot = availableSlot;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getAvailableSlot() {
        return availableSlot;
    }
    public void setAvailableSlot(int availableSlot) {
        this.availableSlot = availableSlot;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId='" + tableId + '\'' +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                ", availableSlot=" + availableSlot +
                '}';
    }
}
