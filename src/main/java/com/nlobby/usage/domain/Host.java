package com.nlobby.usage.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vst_host_user")
public class Host {

    @Id
    private Long id;
}
