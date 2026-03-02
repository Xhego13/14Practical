public class openHash{
   private static class Entry {
        String key;
        String value;
     
    Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
 }

    private LinkedList<Entry>[] table; 
    private int m;
    private int N; 

    // Constructor
    public openHash(int m) {
        this.m = m;
        this.N = 0;
        table = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            table[i] = new LinkedList<>();
        }
    }
    public int hash(String key) {
        int h = key.hashCode();
        return h+(N%m)     
    }
    public void insert(String key, String value) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
        N++;
    }
}
