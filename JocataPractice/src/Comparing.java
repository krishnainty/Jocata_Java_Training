import java.util.ArrayList;
import java.util.Collections;

class Stud implements Comparable<Stud>{
    int id;
    int marks;
    int age;
    Stud(int id,int marks,int age){
        this.id=id;
        this.marks=marks;
        this.age=age;
    }

    @Override
    public int compareTo(Stud o) {
        //
         //return Integer.compare(o.marks,this.marks);
        return this.marks- o.marks;
    }
}
public class Comparing {
    public static void main(String[] args) {


        ArrayList<Stud> li = new ArrayList<>();
        li.add(new Stud(1, 80,20));
        li.add(new Stud(2,110,30));
        li.add(new Stud(3,100,40));
        Collections.sort(li);
        for(Stud s:li)

        System.out.println(s.id+"  "+s.marks+" "+s.age);
    }



}
