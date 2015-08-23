## Paths
### abfrage mit counter
```
GET /greeting
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|name|name|false|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|Greeting|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* greeting-resource

### suche nach einem kunden
```
GET /kunde
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|test|name|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|Kunde|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* kunde-resource

