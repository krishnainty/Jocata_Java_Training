import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Stu{
    int id;
    String name;
    Stu(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return id == stu.id && Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
public class HashCodeTest {
    public static void main(String[] args) {
        Stu st = new Stu(1, "Suresh");
        Stu st1 = new Stu(1, "Suresh");


        HashSet<Stu> hs = new HashSet<>();
        hs.add(st);
        hs.add(st1);
        long stime=System.currentTimeMillis();
        for(long i=0;i<1000000;i++);
        long etime=System.currentTimeMillis();
        System.out.println("Time: "+(etime-stime));

        System.out.println(st.equals(st1));
        System.out.println(hs.size());
        System.out.println(st.hashCode());
        System.out.println();
        String s1=new String("Krishna");
        String s2="Krishna";
        StringBuffer s3=new StringBuffer("Krishna");
        StringBuilder s4=new StringBuilder("Krishna");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3.toString());
        System.out.println(s1.equals(s3.toString()));
        System.out.println(s4.toString().equals(s3.toString()));
        System.out.println();
        Iterator<Stu>it=hs.iterator();
        System.out.println(it.next().name);
        String s5=new String("Krishna");
        System.out.println(s1==s5);
        System.out.println(s1.equals(s5));
        String s6="Krishna";
        s6+="mohan";
        System.out.println(s2==s6);
        System.out.println(s6);
        String s7="Krishna";

//        s3.append("inty");
//        System.out.println(s3);


    }



}

