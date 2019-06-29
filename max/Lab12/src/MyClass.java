import java.util.ArrayList;

public class MyClass {
    private ArrayList<Students> classList;
    private Input MyInput=new Input();

    public void addStudent(Students newStudent)
    {
        classList.add(newStudent);
    }

    public void subStudent()
    {
        classList.remove(0);
    }

    public void display()
    {
        System.out.println("Welcome to Mr. Tsang's class /n");
        System.out.print("Display all sudent?(yes/no): ");
        String judge=MyInput.getString();
        if(judge.equals("yes"))
        {
            for(Students element:classList)
            {
                System.out.print(element.getFirstName()+" "+element.getLastName()+" "+element.getStudent_Number()+" "+element.getGrade()+" "+element.getGender()+" Programming");
                if(element.getProgramming_12_Student())System.out.println("12");
                else System.out.println("11");
            }
        }
        else
        {
            int jud_grade;
            char jud_gender;
            String jud_pro;boolean result=false;
            System.out.print("grade: ");jud_grade=MyInput.getInt();
            //System.out.print("gender: ");jud_gender=MyInput.getChar();
            System.out.print("programming 12: ");jud_pro=MyInput.getString();
            if(jud_pro.equals("yes"))result==true;

            for(Students element:classList)
            {
                if(element.getGrade()==jud_grade)
                    if(element.getGender()==jud_gender)
                     if (element.getProgramming_12_Student() == result)
                     {
                         System.out.print(element.getFirstName()+" "+element.getLastName()+" "+element.getStudent_Number()+" "+element.getGrade()+" "+element.getGender()+" Programming");
                         if(element.getProgramming_12_Student())System.out.println("12");
                         else System.out.println("11");
                     }
            }

        }
    }

}
