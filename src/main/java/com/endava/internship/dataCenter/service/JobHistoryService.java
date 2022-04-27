package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.JobHistory;
import com.endava.internship.dataCenter.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
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

//    public void deleteJobHistory(Integer id){
//        log.info("IN JobHistoryService deleteJobHistory with Id = {}", id);
////        jobHistoryRepository.deleteById(id);
//        JobHistory jobHistory = new JobHistory();
//
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(JobHistory.class)
//                .buildSessionFactory();
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        jobHistory = session.get(JobHistory.class, id);
//        session.delete(jobHistory);
//        //session.createQuery("delete Departments where ... ='...'").executeUpdate();
//        session.getTransaction().commit();
//    }
}
