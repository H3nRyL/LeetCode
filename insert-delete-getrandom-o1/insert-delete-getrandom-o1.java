class RandomizedSet {
    private Set<Integer> set;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.set.contains(val))
            return false;
        else 
            this.set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!this.set.contains(val))
            return false;
        else
            this.set.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(this.set.size());
        Iterator itr = this.set.iterator();
        int currentIndex = 0;
        int randomElement = 0;
  
        while (itr.hasNext()) {
            randomElement = (int)itr.next();

            if (currentIndex == random)
                return randomElement;

            currentIndex++;
        }
  
        return randomElement;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */