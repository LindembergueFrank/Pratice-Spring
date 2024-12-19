CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title varchar(200) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    km INT NOT NULL,
    location varchar(20) NOT NULL,
    PRIMARY KEY(id)
);