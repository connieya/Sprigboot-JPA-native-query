package com.nlobby.usage.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vst_notice")
public class Notice {

    @Id
    private Long id;
}
