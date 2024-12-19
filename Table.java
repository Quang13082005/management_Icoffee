public class Table {
    private String tableId;
    private boolean isAvailable;

    public Table(String tableId, boolean isAvailable) {
        this.tableId = tableId;
        this.isAvailable = isAvailable;
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

    @Override
    public String toString() {
        return "Table{" +
                "tableId='" + tableId + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
