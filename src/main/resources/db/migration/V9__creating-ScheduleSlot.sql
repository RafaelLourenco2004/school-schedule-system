CREATE TABLE schedule_slot (
    id UUID NOT NULL,
    schedule_id UUID NOT NULL,
    period_id UUID NOT NULL,
    subject_id UUID NOT NULL,
    class_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id),
    -- FOREIGN KEY (subject_id) REFERENCES lesson(subject_id),
    -- FOREIGN KEY (class_id) REFERENCES lesson(class_id),
    FOREIGN KEY (subject_id, class_id) REFERENCES lesson(subject_id, class_id),
    FOREIGN KEY (period_id) REFERENCES period(id)
)