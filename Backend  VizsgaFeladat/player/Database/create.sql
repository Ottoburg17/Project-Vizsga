CREATE DATABASE IF NOT EXISTS GolfDB;

CREATE TABLE IF NOT EXISTS Player (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT
);


CREATE TABLE IF NOT EXISTS Result (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    golfTournament TEXT,
    playerId INTEGER,
    round1 INTEGER,
    round2 INTEGER,
    round3 INTEGER,
    round4 INTEGER,
    totalRounds INTEGER,
    FOREIGN KEY (playerId) REFERENCES Player(id)
);