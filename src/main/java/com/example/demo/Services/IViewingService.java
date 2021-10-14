package com.example.demo.Services;

import com.example.demo.Entities.Viewing;

public interface IViewingService {
    void create(Viewing viewing);
    void delete(int viewingId);
    void updateDate(int viewingId);
    Viewing getById(int viewingId);
}
