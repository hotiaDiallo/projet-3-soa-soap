package com.ib.library.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Library {
  @Id
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER)
  private Set<Work> works;

  public Library() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Work> getWorks() {
    return works;
  }

  public void setWorks(Set<Work> works) {
    this.works = works;
  }
}
