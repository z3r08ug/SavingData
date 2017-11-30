package dev.uublabs.savingdata;

/**
 * Created by Admin on 11/13/2017.
 */

public class Person
{
    String name;
    String gender;

    public Person(String name, String gender)
    {
        this.name = name;
        this.gender = gender;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}'+"\n";
    }
}
