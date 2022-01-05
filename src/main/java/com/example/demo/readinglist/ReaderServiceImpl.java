package com.example.demo.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Override
    public Reader findByUsername(String username) {
        return readerRepository.findByUsername(username);
    }
}
