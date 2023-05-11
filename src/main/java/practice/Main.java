package practice;

import HomeWork.Week1Hw;

public class Main {
    public static void main(String [] args){
        LearnLoopArrayList loop = new LearnLoopArrayList();
        loop.whileloop();
        loop.forLoop();
        loop.doWhileLoop();
        loop.ifStatement();
        loop.learnIfElseStatement(35);
        loop.switchStatement('A');
        loop.conditionalOperator();
        loop.stringArray();
        loop.stringArray2();
        loop.stringArrayWhileLoop();
        loop.stringArray3();
        loop.listArray();
        loop.convertArrayToList();
        loop.convertListToArray2();
        loop.indexOf();
        loop.indexOf2();
        loop.indexOf3();
        loop.learnSubString();
        loop.learnReplace();
        loop.learnTrim();
        loop.learnCharAt();
        loop.learnFormat();
        loop.contains();
        loop.learnSplitArray();

        LearnJavaMath learnJavaMath = new LearnJavaMath();
        learnJavaMath.learnRandomize();
        learnJavaMath.learnRounding();
        learnJavaMath.learnMax();

        LearnHashMap learnHashMap = new LearnHashMap();
        learnHashMap.AddHashMapValue();
        learnHashMap.hashMapProblem();

        ReadValueFromTerminal readValueFromTerminal = new ReadValueFromTerminal();
        readValueFromTerminal.getUserInput();

        MyClass myClass = new MyClass(2);
        System.out.println("Value of X: " + myClass.x);

        Account account = new Account();
        account.setDate(2,3);
        account.showData();

        Student s1 = new Student();
        s1.showData();
        Student s2 = new Student();
        s2.showData();
        Student s3 = new Student();
        s3.showData();

        LearnExceptions learnExceptions = new LearnExceptions();
        learnExceptions.testExceptions();
        learnExceptions.addArrayNumbers();
        learnExceptions.subtractArrayNumbers();
        learnExceptions.multiplyArrayNumbers();
        learnExceptions.addArrayNumbers1();

        // I'm manually selecting the specific day below - that allows me to get the message for that day
        String dayName = "FRIDAY";
        LearnEnum learnEnum = new LearnEnum(Day.valueOf(dayName));
        learnEnum.dayIsLike();

        LearnRecursion recursion = new LearnRecursion();
        recursion.printNumbers(1);

        Bicycle bicycle = new Bicycle(4,30);
        bicycle.applyBrake(10);
        bicycle.showData();
        bicycle.speedUp(5);
        bicycle.showData();

        MountainBike mb = new MountainBike(4,30,15);
        mb.showNewInformation();
        mb.speedUp(10);
        mb.showNewInformation();

        Sum sum = new Sum();
        sum.addNumbers(24,34);
        System.out.println("The result is: " + sum);
        sum.addNumbers(12,34,34);

        Encapsulate encapsulate = new Encapsulate();
        encapsulate.setGeekName("Johnathan");
        encapsulate.setGeekRoll(120);
        encapsulate.setGeekAge(25);
        encapsulate.StudentInformation();

        System.out.println("Geek's name is: " + encapsulate.getGeekName());
        System.out.println("Geek's roll is: " + encapsulate.getGeekRoll());
        System.out.println("Geek's Age is: " + encapsulate.getGeekAge());

        encapsulate.StudentInformation();

        Pig pig = new Pig();
        pig.animalSound();

        Pig1 pig1 = new Pig1();
        pig1.animalSound();
        pig1.run();

        //this doesn't print out any values
        Week1Hw week1Hw = new Week1Hw();
        int[] array1 = {1,2,3,4};
        int[] newArray = {1,2,3,4}; //length = 4
        int middleElementIndex = newArray.length/2; //  4/2=2
        int[] middleArray = {newArray[middleElementIndex - 1], newArray[middleElementIndex]};

        Variables objHW1 = new Variables();
        objHW1.intVariables();
        objHW1.printText();
        objHW1.boolVariables();
        objHW1.charVariables();
        objHW1.floatVariables();
        objHW1.strVariables();
//This is the method value of the method parameter in Class: Week1
        int numbers = objHW1.addNumbers(23,34);
        System.out.println("Total is: " + numbers);
    }
}
