package hackerrank.arrays_strings_and_everything;

import java.util.*;
public class Median {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int median;
        System.out.print("Please enter 10 number for which median to be find: ");
        for(int i=0;i < a.length;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
        median = new Median().findMedian(a,0,a.length-1);
        if(a.length%2 != 0)
            System.out.print("median of above array is : "+a[median]);
        else
            System.out.print("median of above array is : "+(a[median] + a[median + 1])/2 );
    }
    public int findMedian(int[] a,int left,int right){
        int index = 0;
        int mid = (left+right)/2;
        index = partition(a,left,right);
        while( index != mid){
            if(index < mid)
                index = partition(a,mid,right);
            else index = partition(a,left,mid);
        }
        return index;
    }
    public int partition(int[] a,int i,int j ){
        int pivot = (i+j)/2;
        int temp;
        while(i <= j){
            while(a[i] < a[pivot])
                i++;
            while(a[j] > a[pivot])
                j--;
            if(i <= j){
                temp = a[i];
                a[i]=a[j];
                a[j] = temp;
                i++;j--;
            }
        }
        return pivot;
    }

}