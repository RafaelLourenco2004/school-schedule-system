CREATE TABLE finished_subject (
    student_id UUID NOT NULL,
    subject_id UUID NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id),
    PRIMARY KEY(student_id, subject_id)
)