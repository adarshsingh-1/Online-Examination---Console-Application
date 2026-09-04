import java.util.*;

interface Exam {
    void display();
}

class User {
    String name, enrollNo, division;

    User(String n, String e, String d) {
        name = n;
        enrollNo = e;
        division = d;
    }

    void showDetails() {
        System.out.println("\nName: " + name);
        System.out.println("Enroll. No.: " + enrollNo);
        System.out.println("Division: " + division);
    }
}


class Questions implements Exam {
    String question;
    String optionA, optionB, optionC, optionD;
    char correctAnswer;

    Questions(String q, String a, String b, String c, String d, char ans) {
        question = q;
        optionA = a;
        optionB = b;
        optionC = c;
        optionD = d;
        correctAnswer = ans;
    }

    public void display() {
        System.out.println("\n\t" + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }
}


class Online {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter (Start/Exit): ");
        String M = s.nextLine();

        if(M.equalsIgnoreCase("Start")){
            System.out.println("\n_____Start the Examination_____\n");
        } else{
            System.out.println("Exit..... ");
            return;
        }

        
        System.out.print("Enter the User ID: ");
        String U = s.nextLine();
        System.out.print("Enter the Password: ");
        String P = s.nextLine();

        if(U.equals("Adarsh")||U.equals("Ashish")||U.equals("Nitesh")&&P.equals("12345")){
            System.out.println("____Login Successful_____");
        } else{
            System.out.println("Invalid Login! Exit..... ");
            return;
        }

        
        System.out.print("\nEnter Name: ");
        String N = s.nextLine();
        System.out.print("Enter Enroll. No.: ");
        String R = s.nextLine();
        System.out.print("Enter Division: ");
        String D = s.nextLine();

        User user = new User(N, R, D);

        
        ArrayList<Questions> questionBank = new ArrayList<>();

        questionBank.add(new Questions("What is Java?", "Programming Language", "Car", "Animal", "Food", 'A'));
        questionBank.add(new Questions("Which is not OOP concept?", "Inheritance", "Encapsulation", "Compilation", "Polymorphism", 'C'));
        questionBank.add(new Questions("Java is platform?", "Dependent", "Independent", "Both", "None", 'B'));
        questionBank.add(new Questions("Which is JVM?", "Machine", "Compiler", "Interpreter", "None", 'A'));
        questionBank.add(new Questions("Which keyword is used for inheritance?", "this", "super", "extends", "implements", 'C'));
        questionBank.add(new Questions("Which is not Java feature?", "Secure", "Robust", "Pointers", "Portable", 'C'));
        questionBank.add(new Questions("Which component compiles Java?", "JVM", "JRE", "JDK", "JIT", 'C'));
        questionBank.add(new Questions("Which keyword is used to define a class?", "class", "define", "struct", "object", 'A'));
        questionBank.add(new Questions("Which method is entry point of Java?", "start()", "run()", "main()", "init()", 'C'));
        questionBank.add(new Questions("Which package is used for Scanner?", "java.io", "java.util", "java.lang", "java.net", 'B'));
        questionBank.add(new Questions("Which is not a data type?", "int", "float", "boolean", "real", 'D'));
        questionBank.add(new Questions("Which operator is used for comparison?", "=", "==", "+", "%", 'B'));
        questionBank.add(new Questions("Which loop is entry-controlled?", "for", "do-while", "switch", "none", 'A'));
        questionBank.add(new Questions("Which keyword is used to exit loop?", "break", "stop", "exit", "return", 'A'));
        questionBank.add(new Questions("Which is not access modifier?", "public", "private", "protected", "static", 'D'));
        questionBank.add(new Questions("Which concept allows multiple forms?", "Encapsulation", "Inheritance", "Polymorphism", "Abstraction", 'C'));
        questionBank.add(new Questions("Which keyword is used to create object?", "class", "new", "this", "super", 'B'));
        questionBank.add(new Questions("Which function prints output?", "System.in", "System.out.print()", "Scanner", "println()", 'B'));
        questionBank.add(new Questions("Which is not loop?", "for", "while", "if", "do-while", 'C'));
        questionBank.add(new Questions("Which keyword refers to current object?", "this", "super", "self", "object", 'A'));
        questionBank.add(new Questions("Which is parent class keyword?", "this", "super", "extends", "implements", 'B'));
        
        Collections.shuffle(questionBank);

        int score = 0;
        int totalQuestions = 5;

        for (int i = 0; i < totalQuestions; i++) {
            Questions q = questionBank.get(i);

            q.display();
            System.out.print("Enter the Answer: ");
            char answer = s.nextLine().toUpperCase().charAt(0);

            if (answer == q.correctAnswer) {
                score++;
                System.out.println("\nCorrect Answer.....\n");
            } else {
                System.out.println("\nWrong Answer.....");
                System.out.println("Correct answer: "+q.correctAnswer);
            }
        }

        
        user.showDetails();
        System.out.println("Your Score: " + score + "/" + totalQuestions);

        if (score > (totalQuestions/2)) {
            System.out.println("Pass..");
        } else {
            System.out.println("Fail..");
        }
    }
}