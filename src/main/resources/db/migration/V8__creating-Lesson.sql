CREATE TABLE lesson (
    subject_id UUID NOT NULL,
    class_id UUID NOT NULL,
    period_id UUID NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id),
    FOREIGN KEY (class_id) REFERENCES classroom(class_id),
    FOREIGN KEY (period_id) REFERENCES period(period_id),
    PRIMARY KEY (subject_id, class_id)
)