package com.nlobby.usage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "vst_privacy")
public class Privacy {

    @Id
    private Long id;

    private boolean applied;

    private String content;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "en_content")
    private String enContent;
}
