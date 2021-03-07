package it.marczuk.pracadomowa_tydzien8_2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String noteSource;

    public Note(String title, String noteSource) {
        this.title = title;
        this.noteSource = noteSource;
    }
}
