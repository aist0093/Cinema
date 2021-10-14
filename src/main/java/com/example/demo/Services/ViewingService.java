package com.example.demo.Services;

import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ViewingService implements IViewingService{

    private final ViewingRepository viewingRepository;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository){
        this.viewingRepository = viewingRepository;
    }


    @Override
    public void create(Viewing viewing) {
        viewingRepository.save(new Viewing());
    }

    @Override
    public void delete(int viewingId) {
        if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");
        viewingRepository.deleteById(viewingId);
    }

//    @Override
//    public void updateDate(int viewingId) {
//        viewingRepository.findViewingByViewingId(viewingId).setDateTime(Date);
//    }
    @Override
    public Viewing setDateTimeByViewingId(Date dateTime, int viewingId){
        Viewing v = viewingRepository.findViewingByViewingId(viewingId);
        v.setDateTime(dateTime);
        return ;
    }

    @Override
    public Viewing getById(int viewingId) {
        return null;
    }
}
