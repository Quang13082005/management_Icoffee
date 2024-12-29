
import java.time.LocalDateTime;
import java.util.List;

public class Bill {
        private String orderId;
        private String tableId;
        private String employeeId;
        private List<Menu> items;
        private double totalPrice;
        private LocalDateTime orderDate;

    public Bill(String orderId, String tableId, String employeeId, List<Menu> items, double totalPrice, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.employeeId = employeeId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "orderId='" + orderId + '\'' +
                ", tableId='" + tableId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
