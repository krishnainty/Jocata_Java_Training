import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class Student{
    int id;
    int rank;
    Student(int id,int rank){
        this.id=id;
        this.rank=rank;
    }

        }
public class SortList {
    static ArrayList<Student>li=new ArrayList<>();
    public static void main(String[] args) {
        addStu(2,10);
        addStu(1,5);
        addStu(4,9);
        addStu(10,11);
        addStu(5,5);
        addStu(4,9);
        addStu(10,11);

        printStu();
       //remStu(10);
        System.out.println("Duplicates are:");
        getDup();
        System.out.println("After sorting: ");
        //Collections.sort(li,new SortbyRank());
        sortStu();
        printStu();
        //
        // getByRank(11);




    }
    public static void addStu(int id1,int rank1)
    {

        Student s=new Student(id1,rank1);
        li.add(s);
    }
    public static void remStu(int id1){
        for(int i=0;i<li.size();i++)
        {
            Student s1=li.get(i);
            if(s1.id==id1)
                li.remove(s1);

        }
    }
    public static void printStu(){
        for(Student s:li){
            System.out.println("Id: "+s.id+"  Rank: "+s.rank);
        }
    }
    public static void  sortStu(){
        Student[] arr=li.toArray(Student[]::new);
        boolean swap;
        for(int i=0;i< arr.length;i++){
            swap=false;

            for(int j=0;j<arr.length-1;j++){
                Student s1=arr[j];
                Student s2=arr[j+1];

                if(s1.rank>s2.rank){
                    Student temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(swap==false)
                break;
        }
        li.clear();
        for(Student s:arr)
            li.add(s);
    }
    public static void getDup(){
        HashSet<Integer>hs=new HashSet<>();
        for(Student s:li){
            if(hs.contains(s.id)){

                System.out.println("Id :"+s.id+" Rank:"+s.rank);

            }
            else hs.add(s.id);
        }

    }
    public static void getByRank(int rank1){
        for(Student s:li){
            if(s.rank==rank1){
                System.out.println("Id :"+s.id+" Rank:"+s.rank);
            }
        }
    }




}

class SortbyRank implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return s1.rank-s2.rank;
    }


}

