package me.psalguero.student.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "family")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_id")
    private int familyId;

    @Column(name = "family_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent headParent;

}
