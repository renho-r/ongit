package com.renho.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_STUDENT")
public class StudentVo implements Serializable{


    private String id;
    private String name;
    private String seqNumber;
    private String entranceAge;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "seq_number")
    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    @Column(name = "entrance_age")
    public String getEntranceAge() {
        return entranceAge;
    }

    public void setEntranceAge(String entranceAge) {
        this.entranceAge = entranceAge;
    }
}
