CREATE TABLE donor (
                       id SERIAL PRIMARY KEY,
                       full_name TEXT NOT NULL,
                       email TEXT NOT NULL
);

CREATE TABLE payment (
                         id SERIAL PRIMARY KEY,
                         reference TEXT NOT NULL,
                         method TEXT NOT NULL,
                         amount_ar INTEGER NOT NULL,
                         date TIMESTAMP NOT NULL,
                         status TEXT NOT NULL
);

CREATE TABLE donation (
                          id SERIAL PRIMARY KEY,
                          donor_id INTEGER REFERENCES donor(id),
                          payment_id INTEGER REFERENCES payment(id)
);

CREATE TABLE beneficiary (
                             id SERIAL PRIMARY KEY,
                             full_name TEXT NOT NULL,
                             email TEXT NOT NULL
);

CREATE TABLE help (
                      id SERIAL PRIMARY KEY,
                      beneficiary_id INTEGER REFERENCES beneficiary(id),
                      payment_id INTEGER REFERENCES payment(id),
                      description TEXT NOT NULL
);
