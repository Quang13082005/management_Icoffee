public class Client {
    private String id;
    private String name;
    private int phone;
    private String email;
    private double rewardPoint;

    public Client(String id, String name, int phone, String email, double rewardPoint) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rewardPoint = rewardPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(double rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", rewardPoint=" + rewardPoint +
                '}';
    }
}
