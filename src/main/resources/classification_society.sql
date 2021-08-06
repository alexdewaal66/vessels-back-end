--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-08-06 00:04:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 58891)
-- Name: classification_society; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.classification_society (
    id integer NOT NULL,
    name character varying(50),
    native_name character varying(50),
    abbreviation character varying(10),
    start_year smallint,
    end_year smallint,
    head_office character varying(20),
    iacs_member boolean
);


ALTER TABLE public.classification_society OWNER TO postgres;

--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 200
-- Name: TABLE classification_society; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.classification_society IS 'Wikipedia: «A ship classification society or ship classification organisation is a non-governmental organization that establishes and maintains technical standards for the construction and operation of ships and offshore structures. Classification societies certify that the construction of a vessel comply with relevant standards and carry out regular surveys in service to ensure continuing compliance with the standards. Currently, more than 50 organizations describe their activities as including marine classification, twelve of which are members of the International Association of Classification Societies.»';


--
-- TOC entry 201 (class 1259 OID 58894)
-- Name: classification_society_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.classification_society_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.classification_society_id_seq OWNER TO postgres;

--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 201
-- Name: classification_society_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.classification_society_id_seq OWNED BY public.classification_society.id;


--
-- TOC entry 2902 (class 2604 OID 58962)
-- Name: classification_society id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.classification_society ALTER COLUMN id SET DEFAULT nextval('public.classification_society_id_seq'::regclass);


--
-- TOC entry 3038 (class 0 OID 58891)
-- Dependencies: 200
-- Data for Name: classification_society; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.classification_society (id, name, native_name, abbreviation, start_year, end_year, head_office, iacs_member) FROM stdin;
1	Lloyd's Register	\N	LR	1760	\N	London	t
2	Bureau Veritas	\N	BV	1828	\N	Paris	t
3	Austrian Veritas/Adriatic Veritas	\N	AV	1858	1921	Trieste	\N
4	Registro Italiafalse Navale	\N	RINA	1861	\N	Gefalsea	t
5	American Bureau of Shipping	\N	ABS	1862	\N	Houston	t
6	DNV GL (Det falserske Veritas)	\N	DNV GL	1864	\N	Oslo	t
7	Germanischer Lloyd	\N	GL	1867	2013	Hamburg	t
8	Nippon Kaiji Kyokai (ClassNK)	\N	NK	1899	\N	Tokyo	t
9	Russian Maritime Register of Shipping	Российский морской регистр судоходства	RS	1913	\N	Saint Petersburg	t
10	Hellenic Register of Shipping	\N	HR	1919	\N	Piraeus	f
11	Polish Register of Shipping	Polski Rejestr Statków	PRS	1936	\N	Gdańsk	t
12	Croatian Register of Shipping	Hrvatski Registar Brodova	CRS	1949	\N	Split	t
13	Bulgarian Register of Shipping	Български Корабен Регистър	BRS	1950	\N	Varna	f
14	CR Classification Society	\N	CR	1951	\N	Taipei	f
15	China Classification Society	\N	CCS	1956	\N	Beijing	t
16	Korean Register of Shipping	\N	KR	1960	\N	Busan	t
17	Vietnam Register	\N	VR	1964	\N	Hafalsei	f
18	Registro Internacional Naval	\N	RINAVE	1973	2004	Lisbon	f
19	Indian Register of Shipping	\N	IRCLASS	1975	\N	Mumbai	t
20	International Register of Shipping	\N	IRS	1993	\N	Miami	f
21	Shipping Register of Ukraine	Регістр судноплавства України	RU	1998	\N	Kiev	f
22	Dromon Bureau of Shipping	\N	DBS	2003	\N	Piraeus	f
23	Overseas Marine Certification Services	\N	OMCS	2004	\N	Panama	f
24	Maritime Bureau of Africa	\N	MBA	2014	\N	Cape Town	f
25	International Maritime Classification	\N	IMC	2015	\N	Dubai	f
26	Dutch Lloyd	\N	DL	2018	\N	Eindhoven	f
27	Asia Classification Society	\N	ACS	1980	\N	Tehran	f
\.


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 201
-- Name: classification_society_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.classification_society_id_seq', 27, true);


--
-- TOC entry 2904 (class 2606 OID 58965)
-- Name: classification_society classification_society_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.classification_society
    ADD CONSTRAINT classification_society_pkey PRIMARY KEY (id);


-- Completed on 2021-08-06 00:04:23

--
-- PostgreSQL database dump complete
--

