CREATE TABLE schedule_slot (
    id UUID NOT NULL,
    schedule_id UUID NOT NULL,
    period_id UUID NOT NULL,
    lesson_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id),
    FOREIGN KEY (period_id) REFERENCES period(id),
    FOREIGN KEY (lesson_id) REFERENCES lesson(subject_id, class_id)
)