public class Transaction {
    String id;
    String time;
    double amount;
    String location;
    String userId;
    String password;

    public Transaction(String id, String time, double amount, String location, String userId, String password) {
        this.id = id;
        this.time = time;
        this.amount = amount;
        this.location = location;
        this.userId = userId;
        this.password = password;
    }
}