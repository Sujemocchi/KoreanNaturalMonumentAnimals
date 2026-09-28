-- Source: 자연유산(천연기념물+동물)+지정현황_20250630.xlsx (as of 2025-06-30, 102 rows)
-- Rows are inserted in the spreadsheet's order, so id = the spreadsheet's 번호 column.
-- region is NULL where the spreadsheet has '-' (designated as a species, not a specific place).
-- species_name is set only for animals (야생동물·축양동물): the official name without its place qualifier.
-- category (분류: 포유류·조류 …) is set only for animals. It is NOT in the spreadsheet; it is the standard
--   biological class of each species (해송·긴가지해송 are black corals, not pine trees).
-- TODO: description and source_url are not in the spreadsheet (scientific names and photos: see the last section).
--       Fill them only after checking 국가유산포털.

INSERT INTO natural_monument (name, species_name, category, designated_date, heritage_field, region) VALUES
('광릉 크낙새 서식지', NULL, NULL, DATE '1962-12-07', 'HABITAT', '경기도'),
('진천 노원리 왜가리 번식지', NULL, NULL, DATE '1962-12-07', 'BREEDING_GROUND', '충청북도'),
('제주 무태장어 서식지', NULL, NULL, DATE '1962-12-07', 'HABITAT', '제주특별자치도'),
('진도의 진도개', '진도개', 'MAMMAL', DATE '1962-12-07', 'LIVESTOCK', '전라남도'),
('정선 정암사 열목어 서식지', NULL, NULL, DATE '1962-12-07', 'HABITAT', '강원특별자치도'),
('봉화 대현리 열목어 서식지', NULL, NULL, DATE '1962-12-07', 'HABITAT', '경상북도'),
('진도 고니류 도래지', NULL, NULL, DATE '1962-12-07', 'MIGRATION_SITE', '전라남도'),
('울산 귀신고래 회유해면', NULL, NULL, DATE '1962-12-07', 'MIGRATION_SITE', NULL),
('낙동강 하류 철새 도래지', NULL, NULL, DATE '1966-07-23', 'MIGRATION_SITE', '부산광역시'),
('한강의 황쏘가리', '황쏘가리', 'FISH', DATE '1967-07-18', 'WILD_ANIMAL', NULL),
('크낙새', '크낙새', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('따오기', '따오기', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('황새', '황새', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('먹황새', '먹황새', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('고니', '고니', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('큰고니', '큰고니', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('혹고니', '혹고니', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('두루미', '두루미', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('재두루미', '재두루미', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('팔색조', '팔색조', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('저어새', '저어새', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('노랑부리저어새', '노랑부리저어새', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('느시(들칠면조)', '느시(들칠면조)', 'BIRD', DATE '1968-05-31', 'WILD_ANIMAL', NULL),
('여주 신접리 백로와 왜가리 번식지', NULL, NULL, DATE '1968-07-24', 'BREEDING_GROUND', '경기도'),
('무안 용월리 백로와 왜가리 번식지', NULL, NULL, DATE '1968-07-24', 'BREEDING_GROUND', '전라남도'),
('흑비둘기', '흑비둘기', 'BIRD', DATE '1968-11-22', 'WILD_ANIMAL', NULL),
('사향노루', '사향노루', 'MAMMAL', DATE '1968-11-22', 'WILD_ANIMAL', NULL),
('산양', '산양', 'MAMMAL', DATE '1968-11-22', 'WILD_ANIMAL', NULL),
('장수하늘소', '장수하늘소', 'INSECT', DATE '1968-11-22', 'WILD_ANIMAL', NULL),
('거제 연안 아비 도래지', NULL, NULL, DATE '1970-11-04', 'MIGRATION_SITE', '경상남도'),
('흑두루미', '흑두루미', 'BIRD', DATE '1970-11-02', 'WILD_ANIMAL', NULL),
('양양 포매리 백로와 왜가리 번식지', NULL, NULL, DATE '1970-11-09', 'BREEDING_GROUND', '강원특별자치도'),
('거제 학동리 동백나무 숲 및 팔색조 번식지', NULL, NULL, DATE '1971-09-13', 'BREEDING_GROUND', '경상남도'),
('울릉 사동 흑비둘기 서식지', NULL, NULL, DATE '1971-12-15', 'HABITAT', '경상북도'),
('금강의 어름치', NULL, NULL, DATE '1972-05-01', 'HABITAT', '충청북도'),
('까막딱따구리', '까막딱따구리', 'BIRD', DATE '1973-04-12', 'WILD_ANIMAL', NULL),
('독수리', '독수리', 'BIRD', DATE '1973-04-12', 'WILD_ANIMAL', NULL),
('검독수리', '검독수리', 'BIRD', DATE '1973-04-12', 'WILD_ANIMAL', NULL),
('참수리', '참수리', 'BIRD', DATE '1973-04-12', 'WILD_ANIMAL', NULL),
('흰꼬리수리', '흰꼬리수리', 'BIRD', DATE '1973-04-12', 'WILD_ANIMAL', NULL),
('철원 철새 도래지', NULL, NULL, DATE '1973-07-10', 'MIGRATION_SITE', '강원특별자치도'),
('횡성 압곡리 백로와 왜가리 번식지', NULL, NULL, DATE '1973-10-05', 'BREEDING_GROUND', '강원특별자치도'),
('한강 하류 재두루미 도래지', NULL, NULL, DATE '1975-02-25', 'MIGRATION_SITE', '경기도'),
('어름치', '어름치', 'FISH', DATE '1978-08-22', 'WILD_ANIMAL', NULL),
('연산 화악리의 오계', '오계', 'BIRD', DATE '1980-04-04', 'LIVESTOCK', '충청남도'),
('무주 일원 반딧불이와 그 먹이 서식지', '반딧불이', 'INSECT', DATE '1982-11-20', 'WILD_ANIMAL', '전북특별자치도'),
('참매', '참매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('붉은배새매', '붉은배새매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('개구리매', '개구리매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('새매', '새매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('알락개구리매', '알락개구리매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('잿빛개구리매', '잿빛개구리매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('매', '매', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('황조롱이', '황조롱이', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('올빼미', '올빼미', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('수리부엉이', '수리부엉이', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('솔부엉이', '솔부엉이', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('쇠부엉이', '쇠부엉이', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('칡부엉이', '칡부엉이', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('소쩍새', '소쩍새', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('큰소쩍새', '큰소쩍새', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('개리', '개리', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('흑기러기', '흑기러기', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('검은머리물떼새', '검은머리물떼새', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('원앙', '원앙', 'BIRD', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('하늘다람쥐', '하늘다람쥐', 'MAMMAL', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('반달가슴곰', '반달가슴곰', 'MAMMAL', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('수달', '수달', 'MAMMAL', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('점박이물범', '점박이물범', 'MAMMAL', DATE '1982-11-16', 'WILD_ANIMAL', NULL),
('신안 칠발도 바닷새류(바다제비, 슴새, 칼새) 번식지', NULL, NULL, DATE '1982-11-20', 'BREEDING_GROUND', '전라남도'),
('제주 사수도 바닷새류(흑비둘기, 슴새) 번식지', NULL, NULL, DATE '1982-11-20', 'BREEDING_GROUND', '제주특별자치도'),
('태안 난도 괭이갈매기 번식지', NULL, NULL, DATE '1982-11-20', 'BREEDING_GROUND', '충청남도'),
('통영 홍도 괭이갈매기 번식지', NULL, NULL, DATE '1982-11-20', 'BREEDING_GROUND', '경상남도'),
('신안 구굴도 바닷새류(뿔쇠오리, 바다제비, 슴새) 번식지', NULL, NULL, DATE '1984-08-13', 'BREEDING_GROUND', '전라남도'),
('제주의 제주마', '제주마', 'MAMMAL', DATE '1986-02-08', 'LIVESTOCK', '제주특별자치도'),
('옹진 신도 노랑부리백로와 괭이갈매기 번식지', NULL, NULL, DATE '1988-08-23', 'BREEDING_GROUND', '인천광역시'),
('노랑부리백로', '노랑부리백로', 'BIRD', DATE '1988-08-23', 'WILD_ANIMAL', NULL),
('경산의 삽살개', '삽살개', 'MAMMAL', DATE '1992-03-10', 'LIVESTOCK', '경상북도'),
('영광 칠산도 괭이갈매기·노랑부리백로·저어새 번식지', NULL, NULL, DATE '1997-12-30', 'BREEDING_GROUND', '전라남도'),
('연천 은대리 물거미 서식지', NULL, NULL, DATE '1999-09-18', 'HABITAT', '경기도'),
('강화 갯벌 및 저어새 번식지', NULL, NULL, DATE '2000-07-06', 'BREEDING_GROUND', '인천광역시'),
('제주연안 연산호 군락', NULL, NULL, DATE '2004-12-13', 'HABITAT', '제주특별자치도'),
('뜸부기', '뜸부기', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('두견', '두견', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('호사비오리', '호사비오리', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('호사도요', '호사도요', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('뿔쇠오리', '뿔쇠오리', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('검은목두루미', '검은목두루미', 'BIRD', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('붉은박쥐(오렌지윗수염박쥐)', '붉은박쥐(오렌지윗수염박쥐)', 'MAMMAL', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('남생이', '남생이', 'REPTILE', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('미호종개', '미호종개', 'FISH', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('꼬치동자개', '꼬치동자개', 'FISH', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('해송', '해송', 'CORAL', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('긴가지해송', '긴가지해송', 'CORAL', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('산굴뚝나비', '산굴뚝나비', 'INSECT', DATE '2005-03-17', 'WILD_ANIMAL', NULL),
('비단벌레', '비단벌레', 'INSECT', DATE '2008-10-08', 'WILD_ANIMAL', NULL),
('화천 황쏘가리 서식지', NULL, NULL, DATE '2011-09-05', 'HABITAT', '강원특별자치도'),
('부여·청양 지천 미호종개 서식지', NULL, NULL, DATE '2011-09-05', 'HABITAT', '충청남도'),
('경주개 동경이', '동경이', 'MAMMAL', DATE '2012-11-06', 'LIVESTOCK', '경상북도'),
('제주 흑우', '제주 흑우', 'MAMMAL', DATE '2013-07-22', 'LIVESTOCK', '제주특별자치도'),
('제주 흑돼지', '제주 흑돼지', 'MAMMAL', DATE '2015-03-17', 'LIVESTOCK', '제주특별자치도'),
('연천 임진강 두루미류 도래지', NULL, NULL, DATE '2022-05-12', 'MIGRATION_SITE', '경기도');

-- Places (서식지·번식지·도래지) linked to a designated animal whose exact name appears in the place's name.
-- Group names such as '고니류', '두루미류', '철새' are not linked, because they don't name one designated animal.
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '광릉 크낙새 서식지' AND a.name = '크낙새';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '거제 학동리 동백나무 숲 및 팔색조 번식지' AND a.name = '팔색조';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '울릉 사동 흑비둘기 서식지' AND a.name = '흑비둘기';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '금강의 어름치' AND a.name = '어름치';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '한강 하류 재두루미 도래지' AND a.name = '재두루미';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '제주 사수도 바닷새류(흑비둘기, 슴새) 번식지' AND a.name = '흑비둘기';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '신안 구굴도 바닷새류(뿔쇠오리, 바다제비, 슴새) 번식지' AND a.name = '뿔쇠오리';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '옹진 신도 노랑부리백로와 괭이갈매기 번식지' AND a.name = '노랑부리백로';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '영광 칠산도 괭이갈매기·노랑부리백로·저어새 번식지' AND a.name = '노랑부리백로';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '영광 칠산도 괭이갈매기·노랑부리백로·저어새 번식지' AND a.name = '저어새';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '강화 갯벌 및 저어새 번식지' AND a.name = '저어새';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '화천 황쏘가리 서식지' AND a.name = '한강의 황쏘가리';
INSERT INTO monument_related_animal (place_id, animal_id)
SELECT p.id, a.id FROM natural_monument p, natural_monument a WHERE p.name = '부여·청양 지천 미호종개 서식지' AND a.name = '미호종개';

-- ===== Scientific names and photos =====
-- scientific_name: checked against Wikidata, 국가유산청 and 국립생물자원관 pages. Domestic breeds get their species name.
-- Photos: freely licensed (CC0 / CC BY / CC BY-SA). Wild animals come from iNaturalist wild (non-captive)
--   observations, preferring ones made in South Korea; domestic breeds come from Wikimedia Commons.
--   The credit columns hold the attribution these licenses require.
UPDATE natural_monument SET scientific_name = 'Canis lupus familiaris' WHERE species_name = '진도개'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Siniperca scherzeri' WHERE species_name = '황쏘가리'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Dryocopus javensis richardsi', image_url = '/images/animals/11.jpg', image_author = 'Renjith Jacob Mathews', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/203238322' WHERE species_name = '크낙새';
UPDATE natural_monument SET scientific_name = 'Nipponia nippon', image_url = '/images/animals/12.jpg', image_author = 'Jiro Iguchi', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/149631320' WHERE species_name = '따오기';
UPDATE natural_monument SET scientific_name = 'Ciconia boyciana', image_url = '/images/animals/13.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/1234125' WHERE species_name = '황새';
UPDATE natural_monument SET scientific_name = 'Ciconia nigra', image_url = '/images/animals/14.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2434428' WHERE species_name = '먹황새';
UPDATE natural_monument SET scientific_name = 'Cygnus columbianus', image_url = '/images/animals/15.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2374809' WHERE species_name = '고니';
UPDATE natural_monument SET scientific_name = 'Cygnus cygnus', image_url = '/images/animals/16.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2409171' WHERE species_name = '큰고니';
UPDATE natural_monument SET scientific_name = 'Cygnus olor', image_url = '/images/animals/17.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2450916' WHERE species_name = '혹고니';
UPDATE natural_monument SET scientific_name = 'Grus japonensis', image_url = '/images/animals/18.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2382482' WHERE species_name = '두루미';
UPDATE natural_monument SET scientific_name = 'Antigone vipio', image_url = '/images/animals/19.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2435481' WHERE species_name = '재두루미';
UPDATE natural_monument SET scientific_name = 'Pitta nympha', image_url = '/images/animals/20.jpg', image_author = 'Tatsutomo Chin', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/25195258' WHERE species_name = '팔색조';
UPDATE natural_monument SET scientific_name = 'Platalea minor', image_url = '/images/animals/21.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2439540' WHERE species_name = '저어새';
UPDATE natural_monument SET scientific_name = 'Platalea leucorodia', image_url = '/images/animals/22.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2402828' WHERE species_name = '노랑부리저어새';
UPDATE natural_monument SET scientific_name = 'Otis tarda', image_url = '/images/animals/23.jpg', image_author = 'Patrick Hacker', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/107661887' WHERE species_name = '느시(들칠면조)';
UPDATE natural_monument SET scientific_name = 'Columba janthina' WHERE species_name = '흑비둘기'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Moschus moschiferus', image_url = '/images/animals/27.jpg', image_author = 'Dmitry Ivanov', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/245048248' WHERE species_name = '사향노루';
UPDATE natural_monument SET scientific_name = 'Naemorhedus caudatus' WHERE species_name = '산양'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Callipogon relictus' WHERE species_name = '장수하늘소'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Grus monacha' WHERE species_name = '흑두루미'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Dryocopus martius', image_url = '/images/animals/36.jpg', image_author = 'Ирина Хохрякова', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/329464126' WHERE species_name = '까막딱따구리';
UPDATE natural_monument SET scientific_name = 'Aegypius monachus', image_url = '/images/animals/37.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2435415' WHERE species_name = '독수리';
UPDATE natural_monument SET scientific_name = 'Aquila chrysaetos', image_url = '/images/animals/38.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2398802' WHERE species_name = '검독수리';
UPDATE natural_monument SET scientific_name = 'Haliaeetus pelagicus', image_url = '/images/animals/39.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2405787' WHERE species_name = '참수리';
UPDATE natural_monument SET scientific_name = 'Haliaeetus albicilla', image_url = '/images/animals/40.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2471316' WHERE species_name = '흰꼬리수리';
UPDATE natural_monument SET scientific_name = 'Hemibarbus mylodon' WHERE species_name = '어름치'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Gallus gallus domesticus' WHERE species_name = '오계'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = NULL WHERE species_name = '반딧불이'; -- TODO: scientific name, photo not confirmed yet
UPDATE natural_monument SET scientific_name = 'Accipiter gentilis', image_url = '/images/animals/47.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2435460' WHERE species_name = '참매';
UPDATE natural_monument SET scientific_name = 'Accipiter soloensis', image_url = '/images/animals/48.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/1228484' WHERE species_name = '붉은배새매';
UPDATE natural_monument SET scientific_name = 'Circus spilonotus', image_url = '/images/animals/49.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2490924' WHERE species_name = '개구리매';
UPDATE natural_monument SET scientific_name = 'Accipiter nisus', image_url = '/images/animals/50.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2450837' WHERE species_name = '새매';
UPDATE natural_monument SET scientific_name = 'Circus melanoleucos', image_url = '/images/animals/51.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2448868' WHERE species_name = '알락개구리매';
UPDATE natural_monument SET scientific_name = 'Circus cyaneus', image_url = '/images/animals/52.jpg', image_author = 'WATANABE Hitoshi 渡辺仁', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/203469601' WHERE species_name = '잿빛개구리매';
UPDATE natural_monument SET scientific_name = 'Falco peregrinus', image_url = '/images/animals/53.jpg', image_author = 'Борис Георги', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/231661651' WHERE species_name = '매';
UPDATE natural_monument SET scientific_name = 'Falco tinnunculus', image_url = '/images/animals/54.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2469914' WHERE species_name = '황조롱이';
UPDATE natural_monument SET scientific_name = 'Strix aluco', image_url = '/images/animals/55.jpg', image_author = 'observe-syz', image_license = 'CC0 1.0', image_license_url = 'https://creativecommons.org/publicdomain/zero/1.0/', image_source_url = 'https://www.inaturalist.org/observations/316464969' WHERE species_name = '올빼미';
UPDATE natural_monument SET scientific_name = 'Bubo bubo' WHERE species_name = '수리부엉이'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Ninox scutulata', image_url = '/images/animals/57.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2443294' WHERE species_name = '솔부엉이';
UPDATE natural_monument SET scientific_name = 'Asio flammeus', image_url = '/images/animals/58.jpg', image_author = 'Kim, Hyun-tae', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/2435503' WHERE species_name = '쇠부엉이';
UPDATE natural_monument SET scientific_name = 'Asio otus', image_url = '/images/animals/59.jpg', image_author = 'Charlotte Kirchner', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/320382484' WHERE species_name = '칡부엉이';
UPDATE natural_monument SET scientific_name = 'Otus sunia', image_url = '/images/animals/60.jpg', image_author = 'Wang.QG', image_license = 'CC BY 4.0', image_license_url = 'https://creativecommons.org/licenses/by/4.0/', image_source_url = 'https://www.inaturalist.org/observations/137142507' WHERE species_name = '소쩍새';
UPDATE natural_monument SET scientific_name = 'Otus bakkamoena' WHERE species_name = '큰소쩍새'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Anser cygnoides' WHERE species_name = '개리'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Branta bernicla' WHERE species_name = '흑기러기'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Haematopus ostralegus' WHERE species_name = '검은머리물떼새'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Aix galericulata' WHERE species_name = '원앙'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Pteromys volans' WHERE species_name = '하늘다람쥐'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Ursus thibetanus' WHERE species_name = '반달가슴곰'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Lutra lutra' WHERE species_name = '수달'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Phoca largha' WHERE species_name = '점박이물범'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Equus caballus' WHERE species_name = '제주마'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Egretta eulophotes' WHERE species_name = '노랑부리백로'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Canis lupus familiaris' WHERE species_name = '삽살개'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Gallicrex cinerea' WHERE species_name = '뜸부기'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Cuculus poliocephalus' WHERE species_name = '두견'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Mergus squamatus' WHERE species_name = '호사비오리'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Rostratula benghalensis' WHERE species_name = '호사도요'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Synthliboramphus wumizusume' WHERE species_name = '뿔쇠오리'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Grus grus' WHERE species_name = '검은목두루미'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Myotis rufoniger' WHERE species_name = '붉은박쥐(오렌지윗수염박쥐)'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Mauremys reevesii' WHERE species_name = '남생이'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Cobitis choii' WHERE species_name = '미호종개'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Pseudobagrus brevicorpus' WHERE species_name = '꼬치동자개'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Myriopathes japonica' WHERE species_name = '해송'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Myriopathes lata' WHERE species_name = '긴가지해송'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Hipparchia autonoe' WHERE species_name = '산굴뚝나비'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Chrysochroa coreana' WHERE species_name = '비단벌레'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Canis lupus familiaris' WHERE species_name = '동경이'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Bos taurus' WHERE species_name = '제주 흑우'; -- TODO: no freely licensed photo yet
UPDATE natural_monument SET scientific_name = 'Sus scrofa domesticus' WHERE species_name = '제주 흑돼지'; -- TODO: no freely licensed photo yet
