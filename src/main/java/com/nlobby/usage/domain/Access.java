package com.nlobby.usage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vst_access_log")
public class Access {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visit_request_id" ,
            insertable = false,
            updatable = false ,
            referencedColumnName = "id"
            )
    private Request request;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Request request;


    @Column(name = "entrance_date")
    private Timestamp entranceDate;

    @Column(name = "exit_date")
    private Timestamp exitDate;

}
