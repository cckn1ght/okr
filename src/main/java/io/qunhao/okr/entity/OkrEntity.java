package io.qunhao.okr.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class OkrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long ownerId;

    private String owner;
    private String title;
    private String obj;
    private String[] krs;
}
