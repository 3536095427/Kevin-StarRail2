package com.atguigu.myexception;

public class DAOException extends RuntimeException {
    public DAOException(String info) {
        super(info);
    }

    public DAOException() {
        super();
    }
}
