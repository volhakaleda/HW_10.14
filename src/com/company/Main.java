package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        /**
         * A class representing a simulation program, which edits history.
         */


                System.out.println("You could start writing now... Or choose one of the commands copy, delete, undo or quit.");
                simulateProgram();
            }

            public static void simulateProgram() {

                Stack<String> stack = new Stack<>();// creates a Stack that will keep all the elements(newly added strings, copied, deleted items)
                String recentlyDeleted = "";
                String recentlyAdded="";


                Scanner scanner = new Scanner(System.in);

                while (true) {

                    String userInput = scanner.nextLine();// expects a user's input

                    if (userInput.equalsIgnoreCase("copy")) { //if user inputs "copy"
                        if(stack.size() == 10) { // if the stack size is 10, the last element is deleted and the newly copied item inserted
                            stack.pop();
                        }
                        recentlyAdded = stack.peek();
                        stack.push(recentlyAdded);// if stack size is no more than 10 elements, the last element is copied to stack
                    } else if (userInput.equalsIgnoreCase("delete")) { //if user inputs "delete"
                        recentlyDeleted = stack.pop(); // deletes a last item in stack

                    } else if (userInput.equalsIgnoreCase("undo")) { //if user inputs "undo"
                        if(stack.size() ==10) {//if the stack size is 10, the last element is deleted
                            stack.pop();
                        }
                        stack.push(recentlyDeleted);// the latest deleted element is put back to stack
                        recentlyDeleted = "";

                    } else if (userInput.equalsIgnoreCase("quit")) { //if user inputs "quit"
                        System.out.println("The program terminates"); // program terminates
                        break;

                    } else {
                        if(stack.size() == 10) { //if the stack size is 10, the last element is deleted
                            stack.pop();
                        }
                        stack.push(userInput);// new string added to stack

                    }
                    System.out.println(Arrays.toString(stack.toArray()));

                }

            }

        }



