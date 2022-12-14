CREATE OR REPLACE FUNCTION propulsion_type_id(x character varying) RETURNS bigint AS
'SELECT propulsion_type.id
 FROM propulsion_type
 WHERE x = name_en'
    LANGUAGE sql;

INSERT INTO propulsion_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES ('alexdewaal', null, 'voortstuwing', 'propulsion', 'hoofd categorie', 'root category', '2022-01-01');

INSERT INTO propulsion_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES ('deskundige', propulsion_type_id('propulsion'),
        'spierkracht', 'manpower', 'bijvoorbeeld roeien', 'rowing for example', '2022-01-01');

INSERT INTO propulsion_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES ('deskundige', propulsion_type_id('propulsion'),
        'wind', 'sailing', 'zeilen', 'wind', '2022-01-01');

INSERT INTO propulsion_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES ('deskundige', propulsion_type_id('propulsion'),
        'mechanisch', 'mechanical', 'motoren', 'engines', '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('manpower'),
        'roeiriem', 'oar', null,
        'One of the oldest forms of marine propulsion, oars have been found dating back to 5000-4500 BCE. Oars have a flat blade at one end. Rowers grasp the oar at the other end. Oars are used exclusively for rowing. In rowing the oar is connected to the vessel by means of a pivot point for the oar, either an oarlock, or a thole. The oar is placed in the pivot point with a short portion inside the vessel, and a much larger portion outside. The rower pulls on the short end of the oar, while the long end is in the water.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('manpower'),
        'peddel', 'paddle', null, 'Paddles are held in both hands by the paddler, and are not attached to the vessel. ',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('manpower'),
        'jagen', 'towpath',
        'Jagen is het voortbewegen van een schip door trekken aan een touw. Het is het meest bekend van de trekschuit, maar jagen is veel ouder. Het was gebruikelijk voor alle schepen bij ongunstige wind en gebeurt ook tegenwoordig nog (machinaal) in sluizen.',
        'A towpath is a road or trail on the bank of a river, canal, or other inland waterway. The purpose of a towpath is to allow a land vehicle, beasts of burden, or a team of human pullers to tow a boat, often a barge. This mode of transport was common where sailing was impractical due to tunnels and bridges, unfavourable winds, or the narrowness of the channel.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('manpower'),
        'wrikken', 'stern sculling',
        'Wrikken is manier van roeien met één riem, waarmee kleine boten over het water worden voortbewogen. Hiertoe wordt een wrikriem aan de achterzijde van de boot via een wrikgat in de spiegel of via een wrikdol in het water gestoken. Door met de bovenzijde van de riem een min of meer 8-vormige beweging te maken (die er in het water als een Z uitziet), waarbij de riem aan het eind van de slag bijna een halve slag wordt geroteerd, ontstaat een voortstuwende kracht. De riem komt daarbij niet uit het water.',
        'Stern sculling is the use of a single oar over the stern of a boat to propel it with side-to-side motions that create forward lift in the water. It is distinguished from sculling, which is rowing with two oars on either side of the boat and from sweep rowing, whereby each boat crew member employs a single oar, complemented by another crew member on the opposite side with an oar, usually with each pulling an oar with two hands.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('manpower'),
        'bomen', 'setting pole',
        'Bomen is een manier van voortstuwen van een boot in ondiep water. Een lange staak of (vaar)boom wordt hiertoe in het water in de bodem gestoken, en het schip wordt vooruitgeduwd.',
        'A setting pole or quant (quant pole) is a pole, handled by a single individual, made to move boats, barges (barge pole) or punts by pushing the craft in the desired direction. Because it is a pushing tool, it is generally used from the stern (back) of the craft.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('mechanical'),
        'schroef', 'propeller', null,
        'Marine propellers are also known as "screws". There are many variations of marine screw systems, including twin, contra-rotating, controllable-pitch, and nozzle-style screws. While smaller vessels tend to have a single screw, even very large ships such as tankers, container ships and bulk carriers may have single screws for reasons of fuel efficiency. Other vessels may have twin, triple or quadruple screws. Power is transmitted from the engine to the screw by way of a propeller shaft, which may be connected to a gearbox.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('mechanical'),
        'scheprad', 'paddle wheel', null,
        'The paddle wheel is a large wheel, generally built of a steel framework, upon the outer edge of which are fitted numerous paddle blades (called floats or buckets). The bottom quarter or so of the wheel travels underwater. Rotation of the paddle wheel produces thrust, forward or backward as required. More advanced paddle wheel designs have featured feathering methods that keep each paddle blade oriented closer to vertical while it is in the water; this increases efficiency. The upper part of a paddle wheel is normally enclosed in a paddlebox to minimise splashing.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('mechanical'),
        'waterjet', 'pump-jet', null,
        'A pump-jet, hydrojet, or water jet is a marine system that produces a jet of water for propulsion. The mechanical arrangement may be a ducted propeller (axial-flow pump), a centrifugal pump, or a mixed flow pump which is a combination of both centrifugal and axial designs. The design also incorporates an intake to provide water to the pump and a nozzle to direct the flow of water out of the pump.',
        '2022-01-01');

INSERT INTO propulsion_type (super_type_id, name_nl, name_en, desc_nl, desc_en, timestamp)
VALUES (propulsion_type_id('mechanical'),
        'Voith Schneider Propeller', 'Voith Schneider Propeller',
        'Een Voith-Schneider-propeller (VSP), ook wel kantelbladschroef of cycloïdeschroef genoemd, is een verticale scheepsschroef. Het voordeel van het gebruik van de schroef is dat het een schip een hoge mate van wendbaarheid geeft. ',
        'A Voith Schneider Propeller (VSP) is a practical cyclorotor that provides instant thrust in any direction. There is no need to turn a propulsor. Most ships with VSPs do not need or have a rudder. VSPs are often used in tugboats, drilling vessels, and other watercraft that require unusually good maneuverability. First deployed in the 1930s, Voith-Schneider drives are both reliable and available in large sizes.',
        '2022-01-01');
