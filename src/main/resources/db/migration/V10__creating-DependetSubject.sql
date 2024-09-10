CREATE TABLE dependent_subject (
    dependent_subject_id UUID,
    dependable_subject_id UUID,
    FOREIGN KEY (dependable_subject_id) REFERENCES subject(id),
    FOREIGN KEY (dependent_subject_id) REFERENCES subject(id),
    PRIMARY KEY (dependent_subject_id ,dependable_subject_id)
)