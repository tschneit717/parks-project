CREATE TABLE address_types
(
    id           INT NOT NULL UNIQUE PRIMARY KEY,
    address_type VARCHAR(255)
);

CREATE TABLE parks
(
    id               INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    park_description VARCHAR(255),
    designation      VARCHAR(255),
    directions_info  VARCHAR(255),
    directions_url   VARCHAR(255),
    full_name        VARCHAR(255),
    latitude         DOUBLE,
    longitude        DOUBLE,
    park_name        VARCHAR(255),
    park_url         VARCHAR(255),
    weather_info     VARCHAR(255)
);

CREATE TABLE addresses
(
    id              INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    line_1          VARCHAR(255),
    line_2          VARCHAR(255),
    line_3          VARCHAR(255),
    city            VARCHAR(255),
    state_code      CHAR(2),
    postal_code     CHAR(5),
    park_id         INT,
    address_type_id INT,
    FOREIGN KEY (address_type_id) REFERENCES address_types (id),
    FOREIGN KEY (park_id) REFERENCES parks (id)
);

ALTER TABLE parks MODIFY park_description VARCHAR(4000);

INSERT INTO address_types (id, address_type)
VALUES (1, 'Physical');
INSERT INTO address_types(id, address_type)
VALUES (2, 'Mailing');

ALTER TABLE parks MODIFY directions_info VARCHAR(4000);
ALTER TABLE parks MODIFY weather_info VARCHAR(4000);

INSERT INTO parks (park_description,
                   designation,
                   directions_info,
                   directions_url,
                   full_name,
                   latitude,
                   longitude,
                   park_name,
                   park_url,
                   weather_info)
VALUES ('Visit Yellowstone and experience the world''s first national park. Marvel at a volcano''s hidden power rising up in colorful hot springs, mudpots, and geysers. Explore mountains, forests, and lakes to watch wildlife and witness the drama of the natural world unfold. Discover the history that led to the conservation of our national treasures ''for the benefit and enjoyment of the people.''',
        'National Park',
        'Yellowstone National Park covers nearly 3,500 square miles in the northwest corner of Wyoming (3% of the park is in Montana and 1% is in Idaho). Yellowstone has five entrance stations, and several are closed to regular vehicles during winter. It takes many hours to drive between these entrances, so be sure to check the status of roads at the entrance you intend to use while planning your trip and before you arrive.',
        'https://www.nps.gov/yell/planyourvisit/directions.htm',
        'Yellowstone National Park',
        44.59824417,
        -110.5471695,
        'Yellowstone',
        'https://www.nps.gov/yell/index.htm',
        'Yellowstone''s weather can vary quite a bit, even in a single day. In the summer, daytime highs can exceed 70F (25C), only to drop 20 or more degrees when a thunderstorm rolls through. It can snow during any month of the year, and winter lows frequently drop below zero, especially at night. Bring a range of clothing options, including a warm jacket and rain gear, even in the summer.');



INSERT INTO addresses (line_1,
                       line_2,
                       line_3,
                       city,
                       state_code,
                       postal_code,
                       park_id,
                       address_type_id)
VALUES ('2 Officers Row',
        'Yellowstone National Park Headquarters',
        '',
        'Yellowstone National Park',
        'WY',
        '82190',
        1,
        1);


INSERT INTO addresses(line_1,
                      line_2,
                      line_3,
                      city,
                      state_code,
                      postal_code,
                      park_id,
                      address_type_id)
VALUES ('P.O. Box 168',
        '',
        '',
        'Yellowstone National Park',
        'WY',
        '82190',
        1,
        2);

DELETE FROM addresses WHERE id = 2;

SELECT *
FROM parks p
INNER JOIN addresses
ON p.id = addresses.park_id
WHERE p.id = 1;