package org.example.util;

import java.time.LocalDate;

public class EmployeeHandler {
    public static Boolean checkUsername(String username){
        return username.length() <= 255;
    }
    public static Boolean checkPhonenumber(String phoneNumber){
        return phoneNumber.matches("[0-9]*") && phoneNumber.length() == 11;
    }
    public static Boolean checkDate(LocalDate startDate, LocalDate Birthday ){
        return (startDate.isBefore(LocalDate.now()) || startDate.isEqual(LocalDate.now())) &&
                (Birthday.isBefore(LocalDate.now()) || Birthday.isEqual(LocalDate.now()));

    }
    public static Boolean checkEmail(String email){
        return email.length() <= 255 && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$\"") ;
    }
}
