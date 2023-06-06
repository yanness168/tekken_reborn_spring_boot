CREATE TABLE IF NOT EXISTS FIGHTERS (
                                        id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                        name VARCHAR(50) NOT NULL,
                                        damage INT NOT NULL,
                                        health INT NOT NULL,
                                        resistance DECIMAL(3,2) NOT NULL,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        anime_from VARCHAR(50) NOT NULL
);


