-- Donateur (donor)
INSERT INTO donor (full_name, email)
VALUES ('Mihago Rasoa', 'mihago@rasoa.mg');

-- Paiement en cours de vérification (payment)
INSERT INTO payment (reference, method, amount_ar, date, status)
VALUES ('MP250804.0910.A02057', 'Orange Money', 10000, '2025-07-29 11:30:00', 'VERIFYING');
