CREATE TABLE period (
    id UUID NOT NULL,
    day_week week_day NOT NULL,
    time TIME NOT NULL,
    PRIMARY KEY (id)
)