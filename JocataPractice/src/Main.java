import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int arr[]={1,2,3};

//        System.out.println(arr);
//        int b[]=new int[arr.length+1];
//        for(int i=0;i<arr.length;i++)
//            b[i]=arr[i];
//        b[b.length-1]=4;
       // arr=new int[arr.length+1];

        arr= Arrays.copyOf(arr,arr.length+1);
        arr[3]=4;
//        System.out.println(arr);
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
        System.out.println(Arrays.toString(arr));


    }
}