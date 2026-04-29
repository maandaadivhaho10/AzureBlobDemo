package com.blobs.demoblobs.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Issue {
    @Id
    @GeneratedValue
    private  Long id;
    private  String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private  User user;
}
