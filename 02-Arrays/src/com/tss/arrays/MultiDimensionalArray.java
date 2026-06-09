package com.tss.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiDimensionalArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m,n;


        do {
            try {
                System.out.print("Enter number of rows: ");
                m = scanner.nextInt();
                if (m <= 0) {
                    System.out.println("Size cannot be less than or equal to 0");
                    continue;
                }

                System.out.print("Enter number of columns: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Size cannot be less than or equal to 0");
                    continue;
                }

                break; // valid input, exit loop

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.nextLine();
            }
        } while (true);


        boolean exit = false;

        int mat1[][] = new int[m][n];
        int mat2[][] = new int[m][n];

      while(true)
      {
          int choice = 0;
          System.out.println("1. Read Matrix \n 2.Print Maxtrix \n3.Addition matrix \n4.  Multiplicaiton Matrix \n5.Exit");

          try {
              choice = scanner.nextInt();
          }catch (InputMismatchException e)
          {
              System.out.println("Please enter a valid value from above!");
          }
          switch (choice){
              case 1:
                  System.out.println("Enter Value for Matrix 1:");
                  for (int i = 0; i < m; i++) {
                      for (int j = 0; j < n; j++) {
                          while (true) {
                              try {
                                  System.out.print("Value for [" + i + "][" + j + "]: ");
                                  mat1[i][j] = scanner.nextInt();
                                  break;
                              } catch (InputMismatchException e) {
                                  System.out.println("Invalid input! Please enter an integer.");
                                  scanner.nextLine();
                              }
                          }
                      }
                  }
                  System.out.println("Enter Values for Matrix 2:");
                  for (int i = 0; i < m; i++) {
                      for (int j = 0; j < n; j++) {
                          while (true) {
                              try {
                                  System.out.print("Value for [" + i + "][" + j + "]: ");
                                  mat2[i][j] = scanner.nextInt();
                                  break;
                              } catch (InputMismatchException e) {
                                  System.out.println("Invalid input! Please enter an integer.");
                                  scanner.nextLine();
                              }
                          }
                      }
                  }
                  break;

              case 2:
                  System.out.println("Matrix 1:");
                  for(int i = 0; i < m; i++)
                  {
                      for(int j = 0; j < n; j++)
                      {
                          System.out.print(mat1[i][j] + " ");
                      }
                      System.out.println();
                  }

                  System.out.println("Matrix 2:");
                  for(int i = 0; i < m; i++)
                  {
                      for(int j = 0; j < n; j++)
                      {
                          System.out.print(mat2[i][j] + " ");
                      }
                      System.out.println();
                  }
                  break;

              case 3:
                  System.out.println("Addition of matrix is: ");
                  for(int i = 0; i < m; i++)
                  {
                      for(int j = 0; j < n; j++)
                      {
                          System.out.print(mat1[i][j] + mat2[i][j] +" ");
                      }
                      System.out.println();
                  }
                  break;

              case 4:
                  System.out.println("Multiplicaion of matrix is: ");
                  for(int i = 0; i < m; i++)
                  {
                      for(int j = 0; j < n; j++)
                      {
                          System.out.print(mat1[i][j] * mat2[i][j] + " ");
                      }
                      System.out.println();
                  }
                  break;

              case 5:
                  return;

              default:
                  System.out.println("Please enter a valid choice");
          }
      }
    }
}
