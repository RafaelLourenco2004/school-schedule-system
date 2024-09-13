package com.example.demo.core.entitys;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "lesson")
public class Lesson {

    @EmbeddedId
    private LessonID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Classroom classroom;

    @OneToOne()
    @JoinColumn(name = "period_id")
    private Period period;

    public Lesson(Subject subject, Classroom classroom, Period period) {
        this.subject = subject;
        this.classroom = classroom;
        this.period = period;
        id = new LessonID(subject.getId(), classroom.getId());
    }

}
