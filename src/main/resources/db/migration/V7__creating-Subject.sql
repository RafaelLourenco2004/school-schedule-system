CREATE TABLE subject (
    id UUID NOT NULL,
    name VARCHAR(100) NOT NULL UNIQUE,
    credit INT NOT NULL,
    semester semester_enum NOT NULL,
    PRIMARY KEY(id)
)