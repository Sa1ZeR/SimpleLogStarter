package com.sa1zer.webapp.mapper;

public interface Mapper<F, T> {

    T map(F from);
}
