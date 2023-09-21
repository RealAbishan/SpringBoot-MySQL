package com.example.springbootcrudmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tasks {

    @Id
    @GeneratedValue
    private int taskId;
    private String task;
    private String description;
    private String assign;
    @Column(name="status")
    private String status;


}
