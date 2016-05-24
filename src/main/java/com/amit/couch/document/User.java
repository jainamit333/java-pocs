package com.amit.couch.document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 9/5/16.
 */
@Document(expiry = 1,expiryUnit = TimeUnit.HOURS)
@Data
public class User {


    @Id
    private String id;

    @Field
    private String firstname;

    @Field
    private String lastname;

    @Field
    private List<String> firstnames;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    @Version
    private long version;
}
