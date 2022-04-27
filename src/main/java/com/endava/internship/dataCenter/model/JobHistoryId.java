package com.endava.internship.dataCenter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class JobHistoryId implements Serializable {
    private Integer employee_id;
    private Integer start_date;

}