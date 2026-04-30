package com.blobs.demoblobs.Model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    @Id
    @GeneratedValue
    private Long id;
    private  String path;
    private  String fileName;
    @OneToOne
    @JoinColumn(name = "issue_id")
    private  Issue issue;
}
