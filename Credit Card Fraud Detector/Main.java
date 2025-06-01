import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = readTransactionsFromCSV("transactions.csv");
        FraudDetector detector = new FraudDetector();

        for (Transaction t : transactions) {
            if (detector.isFraudulent(t)) {
                System.out.println("⚠️ Fraudulent Transaction Detected: " + t.id + " by User " + t.userId);
            }
        }
    }

    private static ArrayList<Transaction> readTransactionsFromCSV(String filename) {
        ArrayList<Transaction> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0];
                    String timestamp = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String location = parts[3];
                    String userId = parts[4];
                    String password = parts[5];
                    list.add(new Transaction(id, timestamp, amount, location, userId, password));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return list;
    }
}
