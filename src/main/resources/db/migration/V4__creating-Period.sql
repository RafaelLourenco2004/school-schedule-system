CREATE TABLE period (
    period_id UUID NOT NULL,
    day_week week_day NOT NULL,
    time TIME NOT NULL,
    PRIMARY KEY (period_id)
)