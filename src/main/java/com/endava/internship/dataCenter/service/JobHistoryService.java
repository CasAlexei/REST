package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.JobHistory;
import com.endava.internship.dataCenter.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;

    public JobHistory getJobHistoryById(Integer id){
        log.info("IN JobHistoryService getJobHistoryById {}", id);
        return jobHistoryRepository.findById(id).orElse(null);
    }

    public void deleteJobHistory(Integer id){
        log.info("IN JobHistoryService deleteJobHistory with Id = {}", id);
//        jobHistoryRepository.deleteById(id);


    }
}
