import java.util.Objects;

class Student1{
    int id;
    String name;
    Student1(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student1 student = (Student1) obj;
        return id == student.id && name.equals(student.name);
    }

   @Override
   public int hashCode() {
        return Objects.hash(id, name);
    }
}
public class Practice {
    public static void main(String[] args) {
        Student1 s1=new Student1(1,"krishna");
        Student1 s2=new Student1(1,"krishna");
        System.out.println(s1.equals(s2));

        String str1=new String("krishna");
        String str2=new String("krishna");
        System.out.println(str1.equals(str2));
    }



}

