package practice;

import java.util.*;

public class LearnLoopArrayList {
    public void whileloop() {
        // Print Numbers from 11 to 20
        int x = 10;
        while (x < 20) {
            System.out.println("I live in NYC");
            System.out.println("I work as an Engineer");
            System.out.println("vale of x: " + x);
            x++;
        }
    }

    public void forLoop() {
        //Print numbers from 1 to 20
        for (int x = 1; x <= 20; x++) {
            System.out.println("Value of x: " + x);
        }
    }

    public void doWhileLoop() {
        //Print numbers from 1 to 100
        int x = 1;
        do {
            System.out.println("This is the value of x: " + x);
            x++;
        } while (x <= 100);

    }

    public void ifStatement() {
        int x = 10;
        //in x value is less than 20 then print the value
        if (x < 20) {
            System.out.println("This is an If Statement");
        }
    }

    public void learnIfElseStatement(int x) {
        if (x < 20) {
            System.out.println("this is if statement & true");
        } else {
            System.out.println("This is not an if Statement & false");
        }
    }

    //Print Results based on the grade
    public void switchStatement(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
            case 'C':
                System.out.println("Well Done");
                break;
            case 'D':
                System.out.println("You Passed");
                break;
            case 'F':
                System.out.println("You Failed");
                break;
            default:
                System.out.println("Invalid Grade");
        }
        System.out.println("Your grade is: " + grade);
    }

    public void conditionalOperator() {
        int a, b;
        a = 10;
        b = (a == 1) ? 20 : 30;
        System.out.println("Value of b is: " + b);

        b = (a == 10) ? 20 : 30;
        System.out.println("Value of b is: " + b);
    }

    public void stringArray() {
        String[] statesName = {"Florida", "New York", "California", "Texas"};
        System.out.println("State name is: " + statesName[0]);
        System.out.println("State name is: " + statesName[1]);
        System.out.println("State name is: " + statesName[2]);
        System.out.println("State name is: " + statesName[3]);
    }

    public void stringArrayWhileLoop() {
        String[] statesName = {"Florida", "New York", "California", "Texas"};
//        int index = 0;
//        while (index < statesName.length) {
//            System.out.println("State name on a while loop is: " + statesName[index]);
//            index++;

        // Here either the above while loop will work, but takes up 4 lines of code while using for reduces
        // it to two lines of code

        for (int index = 0; index < statesName.length; index++) {
            System.out.println("State name on For Loop single line code is: " + statesName[index]);
        }
        // Another way to write the above using two lines of code
        for (String state : statesName) {
            System.out.println("State name is: " + state);
        }
    }

    public void stringArray2() {
        String[] statesName = {"Florida", "New York", "California"};
        int index = 0;
        while (index < statesName.length) {
            System.out.println("State name is for Array2: " + statesName[index]);
            index++;
        }
    }

    public void stringArray3() {
        String[] statesName = {"New Jersey", "Utah", "Montana", "Georgia"};
        Arrays.sort(statesName, Collections.reverseOrder());
        System.out.println(Arrays.toString(statesName));
    }

    //The below is an example of a List.  It's a type of Array, but different because data can be added,
    //modified, removed, without replacing the existing values.
    public void listArray() {
        List<String> lists = new ArrayList<>();

        lists.add("One");
        lists.add("Two");
        lists.add("Three");
        lists.add("Four");

        //This prints out a list of: [One, Two, Three, Four]
        System.out.println(lists);

        //This prints out the same list as above but using a for loop
        for (String list : lists) {
            System.out.println("Print value of list using a for loop: " + list);
        }

        for (int i = 0; i < lists.size(); i++) {
            System.out.println("Print value of list using a for loop with integer is: " + lists.get(i));
        }

        //The below removes the value of Two from the list above, but adds the value of Five
        //after typing list. you should see the other options like add, remove, size, sort, etc.
        lists.remove("Two");
        //lists.remove(1); this can be used to remove Two from the index from 0-4
        lists.add("Five");

        //This prints out a list of: [One, Three, Four, Five]
        System.out.println(lists);
    }

    List<String> list1;
    String[] array3;

    public void convertArrayToList() {
        array3 = new String[]{"VBScript, Java, Python, C#, PHP"};
        //Prints: Printing Array: [VBScript, Java, Python, C#, PHP]
        System.out.println("Printing Array: " + Arrays.toString(array3));

        //Converting Array to List
        list1 = new ArrayList<>();
        for (String language : array3) {
            list1.add(language);
        }

        //Printing the Array converted to List: [VBScript, Java, Python, C#, PHP]
        System.out.println("Print the Array converted to List: " + list1);

        //Adding new value to the list
        list1.add("Ruby");
        list1.add("PHP");

        //Printing the new list with added values
        System.out.println("Printing the Array converted to List with added values: " + list1);

    }

    public void convertListToArray() {
        array3 = new String[]{"Java", "PHP", "Python", "C++"};
        System.out.println("Printing Array" + Arrays.toString(array3));

        //Converting Array to List
        list1 = new ArrayList<>();
        for (String language : array3) {
            list1.add(language);
        }

        System.out.println("Printing List: " + list1);

        list1.add("Ruby");
        list1.add("Visual Basic");

        System.out.println("Printing List after adding new languages: " + list1);
    }

    public void convertListToArray2() {
        array3 = list1.toArray(new String[list1.size()]);
        System.out.println("Printing Array upon converting from list: " + Arrays.toString(array3));
    }

    //Use indexOf method to search large txt for a specific word
    public void indexOf() {
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("planet"));
    }

    //Use indexOf method to search large txt for a specific  after the 15th place
    public void indexOf2() {
        String myStr = "Hello planet earth, you are a great planet.";
        int positionOfPlanet = myStr.indexOf("planet");
        System.out.println(myStr.indexOf("planet", 15));
        System.out.println(positionOfPlanet);
    }

    public void indexOf3() {
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("test"));

        String spaceCount = "            ";
        System.out.println("Length of Empty String: " + spaceCount.length());
    }

    public void learnSubString() {
        String str = "JavaPoint";
        String subStr1 = str.substring(2); //vaPoint
        System.out.println(subStr1);

        String subStr2 = str.substring(0, 4); //Java
        System.out.println(subStr2);

        //Print java from the above string
        //length of Java word is 4
        String searchWord = "Java";
        int searchWordStartingPosition = str.indexOf("Java");
        String subStrJava = str.substring(searchWordStartingPosition, searchWord.length());
        System.out.println("Search Keyword: " + subStrJava);

    }

    public void learnReplace() {
        String str = "Hello World hello";
        String replacedStr = str.replace('l', 'p');
        String replaceWorld = str.replaceAll("World", "Florida");
        String replaceFirst = str.replaceFirst("Hello", "Hi");
        System.out.println(replacedStr);
        System.out.println(replaceWorld);
        System.out.println(replaceFirst);
    }

    public void learnTrim() {
        String str = "    Hello World    ";
        System.out.println(str);
        System.out.println(str.trim());
    }

    public void learnCharAt() {
        //Print a word in reseverse order
        //hello => olleH
        String str = "Hello";
        String reverseWord = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char result = str.charAt(i);
            reverseWord += String.valueOf(result);

            System.out.println(result);
            System.out.println(reverseWord);
        }
    }
    public void learnFormat() {
        // My name is Johnathan, and I am 20 years old and my salary is $40,000 yearly
        String name = "Johnathan";
        int age = 20;
        int salary = 40000;

        System.out.println("My name is " + name + ", and I am " + age + " years old and my salary is " + salary + " yearly");

        //Using the format() to format a string
        String s = String.format("My name is %s, and I am %s years old and my salary is %s yearly", name, age, salary);
        System.out.println(s);
    }

    public void contains() {
        // Contains gives you results in true or false if a particular set of characters is in the String
        String str = "Hello";
        System.out.println(str.contains("Hel"));
        System.out.println(str.contains("llo"));
        System.out.println(str.contains("Fra"));
    }

    public void learnSplitArray() {
        // Prints out the contents of the string separated by the deliminator in this case a comma ,
        String names = "John,Ali,Mohammed,Tim";
        String[] nameArray = names.split(",");
        System.out.println(Arrays.toString(nameArray));
        // The below allows you to pull out the names individually
        for(String name : nameArray) {
            System.out.println("Individual Name: " + name);
        }
    }

    }
