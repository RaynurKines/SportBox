package com.example.sportbox.model;

import com.example.sportbox.model.enums.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;
    private String name;

    @Enumerated
    private Faculty faculty;
    private Date dateStart;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

}
