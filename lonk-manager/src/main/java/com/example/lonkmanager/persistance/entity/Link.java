package com.example.lonkmanager.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;

@Entity
@Table(name = "link", uniqueConstraints = {@UniqueConstraint(name = "UniqueLinkLabel", columnNames = { "name" }) })
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name = "path")
    private String path;



    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATEGORY_LINK"))
    @Fetch(FetchMode.JOIN)
    private Category category;
}