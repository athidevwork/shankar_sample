CREATE TABLE USER(
    --id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    uri VARCHAR(30)
);

CREATE TABLE REPORTS(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    --id NUMBER(10) PRIMARY KEY,
    col1 VARCHAR(20),
    col2 VARCHAR(20),
    col3 VARCHAR(20),
    col4 VARCHAR(20),
    col5 VARCHAR(20),
    col6 VARCHAR(20),
    col7 VARCHAR(20),
    col8 VARCHAR(20),
    col9 VARCHAR(20),
    col10 VARCHAR(20)
);

INSERT INTO REPORTS(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) VALUES
    ('row1-col1', 'row1-col2', 'row1-col3', 'row1-col4', 'row1-col5', 'row1-col6', 'row1-col7', 'row1-col8', 'row1-col9', 'row1-col10'),
    ('row2-col1', 'row2-col2', 'row2-col3', 'row2-col4', 'row2-col5', 'row2-col6', 'row2-col7', 'row2-col8', 'row2-col9', 'row2-col10'),
    ('row3-col1', 'row3-col2', 'row3-col3', 'row3-col4', 'row3-col5', 'row3-col6', 'row3-col7', 'row3-col8', 'row3-col9', 'row3-col10'),
    ('row4-col1', 'row4-col2', 'row4-col3', 'row4-col4', 'row4-col5', 'row4-col6', 'row4-col7', 'row4-col8', 'row4-col9', 'row4-col10'),
    ('row5-col1', 'row5-col2', 'row5-col3', 'row5-col4', 'row5-col5', 'row5-col6', 'row5-col7', 'row5-col8', 'row5-col9', 'row5-col10');
