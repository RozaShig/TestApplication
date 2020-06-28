package com.test.testapplication.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@Service
public class MathReaderService {

    private String doMath (String line) {
        try {
            long operand1, operand2;
            if (line.contains("*")) {
                operand1 = Long.parseLong(line.substring(0, line.indexOf("*")));
                operand2 = Long.parseLong(line.substring(line.indexOf("*") + 1));
                return String.valueOf(operand1 * operand2);
            } else if (line.contains("/")) {
                operand1 = Long.parseLong(line.substring(0, line.indexOf("/")));
                operand2 = Long.parseLong(line.substring(line.indexOf("/") + 1));
                return String.valueOf(operand1 / operand2);
            } else if (line.contains("+")) {
                operand1 = Long.parseLong(line.substring(0, line.indexOf("+")));
                operand2 = Long.parseLong(line.substring(line.indexOf("+") + 1));
                return String.valueOf(operand1 + operand2);
            } else if (line.contains("-")) {
                operand1 = Long.parseLong(line.substring(0, line.indexOf("-")));
                operand2 = Long.parseLong(line.substring(line.indexOf("-") + 1));
                return String.valueOf(operand1 - operand2);
            }
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Строка " + line + " содержит ошибку, один из операндов не является целым числом");
            return null;
        } catch (ArithmeticException e) {
            System.out.println("Строка " + line + " содержит ошибку, деление на 0");
            return null;
        }
    }

    public String doTask(String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("out.txt");
            File outFile = new File("out.txt");

            String line = reader.readLine();
            while (line != null) {

                // действия со строкой
                String result = doMath(line);
                if (result != null)
                    fileWriter.write(result.concat("\n"));

                line = reader.readLine();
            }

            fileWriter.close();
            return outFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
