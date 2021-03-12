package com.nlobby.usage.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vst_sms")
public class SMS {

    @Id
    private Long id;
}
