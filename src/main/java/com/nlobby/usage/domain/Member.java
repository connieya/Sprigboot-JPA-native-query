package com.nlobby.usage.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "members")
public class Member {

    @Id
    private Long id;

    private String content;

    @Column(name = "name")
    private String memberName;

//    private String age;

//    private boolean applied;
//
//    @Column(name = "create_at")
//    private Timestamp createAt;
}
