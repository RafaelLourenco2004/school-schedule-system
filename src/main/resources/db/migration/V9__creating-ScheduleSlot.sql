CREATE TABLE schedule_slot (
    schedule_slot_id UUID NOT NULL,
    schedule_id UUID NOT NULL,
    period_id UUID NOT NULL,
    subject_id UUID NOT NULL,
    class_id UUID NOT NULL,
    PRIMARY KEY (schedule_slot_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(schedule_id),
    -- FOREIGN KEY (subject_id) REFERENCES lesson(subject_id),
    -- FOREIGN KEY (class_id) REFERENCES lesson(class_id),
    FOREIGN KEY (subject_id, class_id) REFERENCES lesson(subject_id, class_id),
    FOREIGN KEY (period_id) REFERENCES period(period_id)
)