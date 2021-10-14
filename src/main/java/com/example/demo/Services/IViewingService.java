package com.example.demo.Services;

import com.example.demo.Entities.Viewing;

import java.util.Date;

public interface IViewingService {
    void create(Viewing viewing);
    void delete(int viewingId);
    Viewing getById(int viewingId);
    Viewing setDateTimeByViewingId(Date dateTime, int viewingId);
}
