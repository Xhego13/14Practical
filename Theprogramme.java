// Code is stored as 13template.java
import java.lang.Math.*;   import java.io.*;   import java.text.*;

public class timeMethods{
int N = 1 << 20;
int[] keys = new int[N];
for (int i = 0; i < N; i++) {
    keys[i] = i;
}
List<Integer> keyList = new ArrayList<>();
for (int k : keys) keyList.add(k);
Collections.shuffle(keyList);

String[][] keyValuePairs = new String[N][2];
for (int i = 0; i < N; i++) {
    keyValuePairs[i][0] = String.valueOf(keyList.get(i));
    keyValuePairs[i][1] = String.valueOf(i + 1);         
}
int usableSize = 950_000;
String[][] usablePairs = Arrays.copyOfRange(keyValuePairs, 0, usableSize);


public static void main(String args[]){

DecimalFormat twoD = new DecimalFormat("0.00");
DecimalFormat fourD = new DecimalFormat("0.0000");
DecimalFormat fiveD = new DecimalFormat("0.00000");

long start, finish;
double runTime = 0, runTime2 = 0, time;
double totalTime = 0.0;
int n = N;
int repetition, repetitions = 30;
runTime = 0;
   for(repetition = 0; repetition < repetitions; repetition++) {
      start = System.currentTimeMillis();
      finish = System.currentTimeMillis();
	  openHash(500);
      time = (double)(finish - start);
      runTime += time;
      runTime2 += (time*time); 
   }
  for(repetition = 0; repetition < repetitions; repetition++) {
      start = System.currentTimeMillis();
      finish = System.currentTimeMillis();
	  chainedHash(1550);
      time = (double)(finish - start);
      runTime += time;
      runTime2 += (time*time); 
   }
  System.out.printf("\n\n\fStatistics\n");
  System.out.println("________________________________________________");
  System.out.println("Total time   =           " + runTime/1000 + "s.");
  System.out.println("Total time\u00b2  =           " + runTime2);
  System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                     + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
  System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
  System.out.println("n            =           " + n);
  System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000) 
                     + '\u00B5' + "s. "); 

  System.out.println("Repetitions  =             " + repetitions);
  System.out.println("________________________________________________");
  System.out.println();
  System.out.println();
}
