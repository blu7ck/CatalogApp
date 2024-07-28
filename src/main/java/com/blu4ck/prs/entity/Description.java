package com.blu4ck.prs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "description")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "specs")
    private String specs;

    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Tech tech;
}
