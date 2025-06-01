public class FraudDetector {
    public boolean isFraudulent(Transaction x){
        if(x.amount> 10000){
            return true; 
        }
        if(x.location.equalsIgnoreCase("Unknown")){
            return true;
        }
        if(isPasswordReversed("secure123", x.password)){
            return true;
        }
        if(isSuspiciousHour(x.time)){
            return true;
        }
        return false;

    }
    private boolean isPasswordReversed(String actual, String entered){
        String reversed = new StringBuilder(actual).reverse().toString();
        return reversed.equals(entered);
    }
    private boolean isSuspiciousHour(String time){
       try {
        String timePart = ""; 
        int tIndex = time.indexOf('T');
        if(tIndex != -1 && time.length() > tIndex + 3) {
            timePart = time.substring(tIndex + 1, tIndex + 6); 
        } 
        else{
            return false; 
        }

        String[] parts = timePart.split(":"); 
        int hour = Integer.parseInt(parts[0]);
        return hour >= 0 && hour < 4;
    } 
    catch(Exception e){
        return false;
    }
}
}
