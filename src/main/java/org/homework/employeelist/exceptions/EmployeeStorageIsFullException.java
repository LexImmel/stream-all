package org.homework.employeelist.exceptions;

public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
