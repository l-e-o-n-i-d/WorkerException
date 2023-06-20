package home_work_8.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Worker[] array = new Worker[1];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Введіть прізвище та ініціали " + (i + 1) + "-го працівника:");
            String surname = sc.nextLine();
            System.out.println("Введіть посаду " + (i + 1) + "-го працівника:");
            String position = sc.nextLine();
            System.out.println("Введіть рік надходження на роботу " + (i + 1) + "-го працівника:");
            int yearWork;
            try{
                yearWork = sc.nextInt();
                if (Integer.toString(yearWork).length() != 4){
                    throw new WrongFormatYearException("Неправильний формат року. Допустимий формат - 'yyyy'");
                } else if (yearWork < 1900 || yearWork > 2023) {
                    throw new OutOfRangeYearException("Допустиме значення року в діапазоні між 1900 та 2023 роком");
                }
            }
            catch (WrongFormatYearException | OutOfRangeYearException ex){
                System.err.println(ex.getMessage());
                yearWork = 2023;
            }
            sc.nextLine();
            array[i] =  new Worker(surname, position, yearWork);
        }
        //сортування
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //виведення на екран прізвища працівника, стаж роботи якого перевищує введене значення
        System.out.println("Введіть стаж роботи:");
        int workExperience = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (workExperience < (2023 - array[i].getYearStartWork())){
                System.out.println(array[i].getSurnameInitials());
            }
        }
    }
}
