package practice;

public class Variables {
    public void printText(){
        System.out.println("Hello World!");
        System.out.println("Whats good in the hood?");
        System.out.println("Were in java Class!");
    }

    public void intVariables(){
        int salary = 1000;
        int hSalary = 2000;
        System.out.println("My salary is: " + salary);
        System.out.println("Adam salary is: " + salary);
        System.out.println("Liz salary is: " + hSalary);
    }

    public void floatVariables(){
        float price = 45.6f;
        System.out.println("Product price is: " + price);
        //hSalary is a local scope so its only accessible via intVariables not floatVariables
        //System.out.println("my name is " + hSalary);
        //Below line is calling a global scope value (value outside the method floatVariables
        System.out.println("Global Scope example is: " + globSalary);
    }

    //Global Scope because this value is injected outside a method it can be used as the value for the line:
    //System.out.println("Global Scope example is: " + salary);
    //That line is using salary
    //its a default access modifier, thus limited within this package homeWork.  doesn't have public in front of it
    int globSalary = 999666;


    public void boolVariables(){
        boolean red = true;
        boolean green = false;
        System.out.println("Red light is: " + red + "Green light is: " + green);
    }

    public void charVariables(){
        char alphabet = 'A';
        System.out.println("Alphabet is: " + alphabet);
    }

    public void strVariables(){
        String name = "Adam";
        String city = "NYC";
        String age = "36";
        System.out.println("My name is " + name + " I live in " + city + " I'm " + age + " years old.");
    }

    public static int returnText(){
        return 5000;
    }

    //method parameter: A variable that has two or more parameters.
    //We use this to make it more dynamic - aka easier to change the script.  In the below:
    //we will inject the values for a and b in the Main method, thus instead of coming to this class to change
    //the value it can be changed directly while running the action.  Its more dynamic and usable.
    public int addNumbers(int a, int b){
        int sum = a + b;
        return sum;
    }

//    public int addNumbers(){
//        int a = 8;
//        int b = 12;
//        int sum = a + b;
//        return sum;
//    }

}

//when you want something private (Access modifiers) you can do a private method, but its limited only to the class,
//so instead of public or default you start it as private void objectName(){}
//anything private should be in your Main class since that's where you run everything

//Protected Access Modifier class is not exposed to others.  It's similar to private and limited to the class its written in.
// Also, It's similar to default access modifier with one exception that its has visibility in sub classes.