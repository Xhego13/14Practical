public class chainedHash{
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
  int N=; 
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
