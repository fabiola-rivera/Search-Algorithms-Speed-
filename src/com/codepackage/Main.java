package com.codepackage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

new Main();
    }
            public Main() {


                int sizeOfDataset = (20_000_000);
                int[] dataset = new int[sizeOfDataset];
                SearchingAlgorithms1.fillArray(dataset, sizeOfDataset);


                String outputFilename = "output1.csv";

                PrintWriter output = null;
                //open output stream


                try {
                    output = new PrintWriter(new FileWriter(outputFilename));


                    int k = 400;


                    for(int sizeOfDataSource = 1 ; sizeOfDataSource < k; sizeOfDataSource++) {

                        int[] dataSource = new int[sizeOfDataSource];
                        Random r = new Random();
                        SearchingAlgorithms1.fillArray(dataSource,r.nextInt(2*sizeOfDataset));

                        long startTime = System.nanoTime();
                        Algorithm1(dataset, dataSource);
                        long stopTime = System.nanoTime();
                        long elapsedTime = stopTime - startTime;
                        double seconds = (double) elapsedTime / 1_000_000_000.0;


                        int[] datasetcopy = Arrays.copyOf(dataset,sizeOfDataset);

                        long startTime2 = System.nanoTime();
                        SearchingAlgorithms1.quickSort(dataset);
                        Algorithm2(datasetcopy, dataSource);
                        long stopTime2 = System.nanoTime();
                        long elapsedTime2 = stopTime2 - startTime2;
                        double seconds2 = (double) elapsedTime2 / 1_000_000_000.0;



                        output.println(sizeOfDataSource + " ,   " + seconds + ", " + seconds2);





                    }





                    output.close();
                }







                catch(IOException ex){
                    System.exit(1);
                }


            }

            public static void Algorithm1 ( int[] arr1, int[] arr2){
                for (int i = 0; i < arr2.length; i++) {
                    int n = arr2[i];
                    System.out.println(SearchingAlgorithms1.sequentialSearch(arr1, n));
                }

            }

            public static void Algorithm2 ( int[] arr1, int[] arr2){


                for (int i = 0; i < arr2.length; i++) {
                    int n2 = arr2[i];
                    System.out.println(SearchingAlgorithms1.binarySearch(arr1, n2));
                }
            }

        }

