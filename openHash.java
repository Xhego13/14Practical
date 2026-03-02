public class openHash{
   private static class Entry {
        String key;
        String value;
     
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] table; 
    int m;
    int N; 

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
    public String lookup(String key) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }
    public String remove(String key) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                String val = e.value;
                table[index].remove(e);
                N--;
                return val;
            }
        }
        return null; 
    }

   
    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    public boolean isFull() {
        return N >= m; 
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public void printTable() {
        for (int i = 0; i < m; i++) {
            System.out.print(i + ": ");
            for (Entry e : table[i]) {
                System.out.print("(" + e.key + ", " + e.value + ") ");
            }
            System.out.println();
        }
    }
  

}
