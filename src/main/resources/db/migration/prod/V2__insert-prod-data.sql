-- Donateur (donor)
INSERT INTO donor (full_name, email)
VALUES ('Lou Andria', 'lou@hei.school');

-- Bénéficiaire (beneficiary)
INSERT INTO beneficiary (full_name, email)
VALUES ('Koto Kely', 'koto@kely.mg');

-- Paiement réussi (payment)
INSERT INTO payment (reference, method, amount_ar, date, status)
VALUES ('AIDE1', 'Orange Money', 5000000, '2025-08-10 09:00:00', 'SUCCEEDED');

-- Aide (help)
INSERT INTO help (beneficiary_id, payment_id, description)
VALUES (
           (SELECT id FROM beneficiary WHERE email = 'koto@kely.mg'),
           (SELECT id FROM payment WHERE reference = 'AIDE1'),
           'Koto a été renversé par une moto et nécessite une chirurgie'
       );
