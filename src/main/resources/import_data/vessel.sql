CREATE OR REPLACE FUNCTION vessel_type_id(x character varying) RETURNS bigint AS
'SELECT vessel_type.id
 FROM vessel_type
 WHERE x = name_en'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION un_locode_id(x character varying) RETURNS bigint AS
'SELECT un_locode.id
 FROM un_locode
 WHERE x = name_diacritics'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION hull_id(x character varying) RETURNS bigint AS
'SELECT hull.id
 FROM hull
 WHERE x = hull_number'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION propulsion_type_id(x character varying) RETURNS bigint AS
'SELECT propulsion_type.id
 FROM propulsion_type
 WHERE x = name_en'
    LANGUAGE sql;

INSERT INTO vessel (hull_id, item_name, mmsi, call_sign, vessel_type_id,
                    propulsion_type_id, un_locode_id,
                    length_oa, beam, draft, displacement,
                    start_date, end_date, timestamp, description)

VALUES (hull_id('IMO8516990'), 'Sc Nordic', null, null, vessel_type_id('cargo'),
        propulsion_type_id('propeller'), un_locode_id('.FAROE ISLANDS'),
        110, 18, 5.6, 4876, TO_DATE('1986', 'YYYY'), null, '2022-01-01', null),

       (hull_id('IMO9464883'), 'Pacific Grebe', '235076847', '2CYN8', null,
        propulsion_type_id('propeller'), un_locode_id('.UNITED KINGDOM'),
        104, 18, 5.8, 6840, TO_DATE('2010', 'YYYY'), null,
        '2022-01-01', null),

       (hull_id('IMO9775749'), 'VOLGA MAERSK', null, null, null,
        propulsion_type_id('propeller'), null,
        200, 36, 9.6, null, null, null, '2022-01-01', null),

       (hull_id('IMO9797735'), 'TORM SUPREME', null, null, null,
        propulsion_type_id('propeller'), null,
        183, 32, 11.6, null, null, null, '2022-01-01', null),

       (hull_id('IMO9649548'), 'Arklow Spray', 250002903, 'EI-OG-8', null,
        propulsion_type_id('propeller'), un_locode_id('Arklow'),
        182, 30.00, 10.00, null, null, null, '2022-01-01',
        E'Class Notation:\nI, Hull Mach, Unrestricted navigation, Bulk Carrier CSR CPS (WBT), BC-A (Holds 2+4 may be empty, ESP, Grab (20), AUT-UMS, MON-SHAFT, ALP, INWATER SURVEY, CLEANSHIP\nPort of Registry: ARKLOW\nYard: Daesun Shipbuilding & Engineering\nYear of Build: 2014\nClass: BUREAU VERITAS\nP&I: NORTH OF ENGLAND\nCall Sign: EI-OG-8\nIMO Number: 9649548\nClass Number: 21950L\nOfficial Number: 404745\nEmail: ASPRAY@ARKSHIP.IE\nContact Number: +353 87 988 9786\nSat Phone: +87 077 324 1541\nMMSI: 250002903'),

       (hull_id('IMO9649536'), 'Arklow Spirit', 250002887, 'EI-OF-4', null,
        propulsion_type_id('propeller'), un_locode_id('Arklow'),
        182, 30.00, 10.00, null, null, null, '2022-01-01',
        'Class Notation:
I, Hull Mach, Unrestricted navigation, Bulk Carrier CSR CPS (WBT), BC-A (Holds 2+4 may be empty, ESP, Grab (20), AUT-UMS, MON-SHAFT, ALP, INWATER SURVEY, CLEANSHIP
Port of Registry: ARKLOW
Yard: Daesun Shipbuilding & Engineering
Year of Build: 2013
Class: BUREAU VERITAS
P&I: NORTH OF ENGLAND
Call Sign: EI-OF-4
IMO Number: 9649536
Class Number: 21949K
Official Number: 404744
Email: ASPIRIT@ARKSHIP.IE
Contact Number: +353 87 138 8563
Sat Phone: +87 077 324 0339
MMSI: 250002887

Length OA: 182.00m
Length BP: 177.52m
Breadth Mld: 30.00m
TPC: 49.4t
Summer Load Draft: 10.00m
Summer Deadweight: 34,905t
Winter Load Draft: 9.798m
Winter Deadweight: 33,905t
GT/NT: 22,868t/11,648t
Min air draft: 36.7m
At max Ballast draft: 6.3m
Min coaming ht above waterline: 10.7m
Ballast excl/incl hold(#3): 13,425t/ 23,374t
Ballast rate p/h (x2): 800m3/hr
IFO380/MGO @ 90%: 1140t/170t
Fresh water: 230t

| Hold Capacities  | No.1 Hold     | No. 2 Hold | No.3 Hold | No.4 Hold | No. 5 Hold | Total    |
| -----------      | ------        | ------     | ------    | ------    | ------    | ------    |
| Grain M3         | 7587.3        | 10056.3    | 9706.7    | 10070.7   | 9529.9    | 46951.0   |
| Grain Ft3        | 267930.3      | 355118.1   | 342772.6  | 355626.6  | 336529.4  | 1657980.6 |
| Bale M3          | 7103.1        | 9648.47    | 9334.8    | 9661.4    | 9209.7    | 44957.5   |
| Bale Ft3         | 250831.8      | 340716.4   | 329639.8  | 341173.0  | 325222.1  | 1587484.2 |
| Hatch Dimensions | 15.2m x 14.8m |                  20.0m x 20.4m                 |           |

Hatch Type: Macgregor Folding type
Cranes: 4 x MacGregor Electric

All holds are appendix B fitted. Mechanical ventilation-6 changes/hr.
Maximum load on tank top: 25t/m2

Speed and Consumption per day (w.o.g):
- Not Scrubber fitted
- Max 0.5% sulphur content
- Ballast:
    Abt. 11.0kts on abt. 15t IFO380/MGO
    Abt. 12.5kts on abt. 18t IFO 380/MGO
    Abt.14.0kts on abt. 23t IFO 380/MGO
- Laden:
    Abt. 11.0kts on abt. 17t IFO380/MGO
    Abt. 12.5kts on abt. 19t IFO 380/MGO
    Abt. 14.0kts on abt. 24t IFO 380/MGO
- In Port (Idle):
    3t MDO/IFO
- In port with cranes:
    4.0t MDO/IFO

Other:
- Co2 Fire Suppression in Cargo Holds
- Mewis Duct
- Australian Ladders Fitted
- BWTS
');
