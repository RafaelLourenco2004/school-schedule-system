CREATE TABLE class (
    id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    semester semester_enum NOT NULL,
    PRIMARY KEY (id)
)