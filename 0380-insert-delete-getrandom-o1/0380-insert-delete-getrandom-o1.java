class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> sequnce;

    public RandomizedSet() {
        map = new HashMap<>();
        sequnce = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, sequnce.size());
        sequnce.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int lastIndex = sequnce.size() - 1;
        int valIndex = map.get(val);
        map.put(sequnce.get(lastIndex), valIndex);
        map.remove(val);

        sequnce.set(valIndex, sequnce.get(lastIndex));
        sequnce.remove(sequnce.size() - 1);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return sequnce.get(random.nextInt(sequnce.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */