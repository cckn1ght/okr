package io.qunhao.okr.entity;
import io.qunhao.okr.entity.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class OkrEntity extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long ownerId;

    private String owner;
    private String title;
    private String obj;

    @ElementCollection
    private List<String> krs;
}
