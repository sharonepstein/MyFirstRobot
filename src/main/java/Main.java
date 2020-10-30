public class Main {
    public static void main (String []args){

    }

   public static int getLargestNumber(int[]arr) {
    int largestnumber = arr[0];
       for (int i = 1; i < arr.length ; i++) {
           if (largestnumber <= arr[i])
            largestnumber = arr[i];


       }
       return largestnumber;
   }
   public static double avg(int[]arr) {
       int sum = 0;
       int theBiggest = arr[0];
       for (int i = 0; i < arr.length; i++) {
           sum += arr[i];

       }
       return (double)sum/arr.length;
   }
}
