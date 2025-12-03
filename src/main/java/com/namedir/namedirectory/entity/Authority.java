package com.namedir.namedirectory.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

    @EmbeddedId
    private AuthorityId id;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.id = new AuthorityId(username, authority);
    }
    
    

}
