# 천연기념물 동물 도감

대한민국 천연기념물 중 **동물**을 소개하는 웹사이트입니다.
목록, 상세 정보, 분류별 필터, 이름 검색을 제공합니다.

> Kotlin + Spring Boot로 만든 학습용 프로젝트입니다.

## 주요 기능

| URL | 내용 |
|---|---|
| `/` | 홈. 사진이 있는 동물 하나를 무작위로 보여줍니다 |
| `/monuments` | 동물 목록 |
| `/monuments?category=BIRD` | 분류별 필터 (포유류·조류·파충류·어류·곤충·산호) |
| `/monuments?q=두루미` | 종 이름 검색 (필터와 함께 사용 가능) |
| `/monuments/{id}` | 동물 상세 정보와 관련 서식지·번식지 |
| `/credits` | 사진 출처와 라이선스 |

## 기술 스택

- Kotlin 2.3, Java 21
- Spring Boot 4.1 (Web MVC, Data JPA, Validation)
- Thymeleaf (서버 사이드 렌더링)
- H2 인메모리 데이터베이스
- CSS (프레임워크 없음)
- Gradle Kotlin DSL

## 실행 방법

Java 21이 필요합니다.

```bash
./gradlew bootRun      # Windows PowerShell: .\gradlew.bat bootRun
```

실행 후 http://localhost:8080 에 접속합니다.

- 테스트: `./gradlew test`
- 빌드: `./gradlew build`
- H2 콘솔: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:monuments`)

데이터베이스는 인메모리라서 실행할 때마다 `data.sql`로 다시 채워집니다.

## 프로젝트 구조

```
src/main/kotlin/com/example/KoreanNaturalMonumentAnimals
├── domain       # 엔티티와 enum (NaturalMonument, AnimalCategory, HeritageField)
├── repository   # JPA 리포지토리
├── service      # 비즈니스 로직과 뷰에 넘기는 DTO
└── controller   # 웹 컨트롤러
src/main/resources
├── data.sql     # 초기 데이터
├── templates    # Thymeleaf 뷰
└── static       # CSS, 이미지
```

## 데이터

- **출처**: 국가유산청 「자연유산(천연기념물+동물) 지정현황」(2025-06-30 기준) 102건
  - 동물(야생동물·축양동물) 71건, 장소(서식지·번식지·도래지) 31건
- **분류**(포유류·조류 등)는 원본 자료에 없어 각 종의 생물 분류를 따로 붙였습니다.
- **학명**은 Wikidata, 국가유산청, 국립생물자원관 자료로 확인했습니다.
- 확인되지 않은 값은 비워 두었습니다. 설명(`description`)은 아직 채우지 않았습니다.

## 사진

사진은 자유 라이선스(CC0, CC BY, CC BY-SA) 이미지만 사용하며, 현재 32종에 사진이 있습니다.

- 출처: [iNaturalist](https://www.inaturalist.org/)의 야생 관찰 기록
- 사진이 없는 동물은 플레이스홀더 이미지를 보여줍니다.

각 사진의 작성자, 라이선스, 원본 링크는 사이트의 `/credits` 페이지에서 확인할 수 있습니다.
사진의 저작권은 각 작성자에게 있으며, 사진에는 표기된 라이선스가 적용됩니다.
