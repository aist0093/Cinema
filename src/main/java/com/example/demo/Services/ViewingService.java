package com.example.demo.Services;

import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.ViewingRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewingService implements IViewingService{

    private final ViewingRepository viewingRepository;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository){
        this.viewingRepository = viewingRepository;
    }
    @Override
    public void create(Viewing viewing) {

    }

    @Override
    public void delete(int viewingId) {
        if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");;
        viewingRepository.deleteById(viewingId);
    }

    @Override
    public void updateDate(int viewingId) {

    }

    @Override
    public Viewing getById(int viewingId) {
        return null;
    }
}
