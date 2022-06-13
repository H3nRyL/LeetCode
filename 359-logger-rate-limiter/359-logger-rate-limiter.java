class Logger {

    private Map<String, Integer> msg;
    
    public Logger() {
        msg = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msg.containsKey(message)) {
            msg.put(message, timestamp);
            return true;
        }
        
        Integer old = msg.get(message);
        if (timestamp - old >= 10) {
            msg.put(message, timestamp);
            return true;
        } else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */