## Definitions
### Greeting
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|content||false|string||
|hohaha||false|LocalDate||
|hossa||false|string||
|id||false|integer (int64)||


### Kunde
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|nachname||false|string||
|vorname||false|string||


### Era
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|value||false|integer (int32)||


### IsoChronology
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|calendarType||false|string||
|id||false|string||


### LocalDate
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|chronology||false|IsoChronology||
|dayOfMonth||false|integer (int32)||
|dayOfWeek||false|enum (MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY)||
|dayOfYear||false|integer (int32)||
|era||false|Era||
|leapYear||false|boolean||
|month||false|enum (JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER)||
|monthValue||false|integer (int32)||
|year||false|integer (int32)||


