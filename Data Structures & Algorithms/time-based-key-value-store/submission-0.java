class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        TreeMap<Integer, String> tree = timeMap.getOrDefault(key, new TreeMap<>());
        tree.put(timestamp, value);
        timeMap.put(key, tree);
    }
    
    public String get(String key, int timestamp) {
        
        if (!timeMap.containsKey(key)) {

            return null;
        }

        Map.Entry<Integer, String> floorEntry = timeMap.get(key).floorEntry(timestamp);

        return floorEntry == null ? null : floorEntry.getValue();
    }
}
